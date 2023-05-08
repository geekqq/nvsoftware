package net.nvsoftware.iorderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.nvsoftware.iorderservice.entity.OrderEntity;
import net.nvsoftware.iorderservice.external.client.PaymentServiceFeignClient;
import net.nvsoftware.iorderservice.external.client.ProductServiceFeignClient;
import net.nvsoftware.iorderservice.model.OrderRequest;
import net.nvsoftware.iorderservice.model.OrderResponse;
import net.nvsoftware.iorderservice.model.PaymentRequest;
import net.nvsoftware.iorderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
@Log4j2

public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductServiceFeignClient productServiceFeignClient;
    @Autowired
    private PaymentServiceFeignClient paymentServiceFeignClient;
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public long placeOrder(OrderRequest orderRequest) { //TODO: make this method as transaction
        log.info("OrderService placeOrder started!");

        //Call OrderService(this) to create order entity with status CREATED, save to orderdb
        log.info("OrderService placeOrder - save to iorderdb started!");
        OrderEntity orderEntity = OrderEntity.builder()
                .productId(orderRequest.getProductId())
                .orderQuantity(orderRequest.getOrderQuantity())
                .totalAmount(orderRequest.getTotalAmount())
                .orderTime(Instant.now())
                .orderStatus("CREATED")
                .paymentMode(orderRequest.getPaymentMode())
                .build();
        orderEntity =  orderRepository.save(orderEntity);
        log.info("OrderService placeOrder - save to iorderdb done!");

        //Call ProductService to check quantity and reduceQuantity if OK
        log.info("ProductServiceFeignClient reduceQuantity started!");
        productServiceFeignClient.reduceQuantity(orderRequest.getProductId(), orderRequest.getOrderQuantity());
        log.info("ProductServiceFeignClient reduceQuantity done!");

        //Call PaymentService to charge paymentMode, mark order COMPLETED if success, otherwise mark CANCELLED

        log.info("PaymentServiceFeignClient doPayment started!");
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .orderId(orderEntity.getOrderId())
                .paymentMode(orderRequest.getPaymentMode())
                .totalAmount(orderRequest.getTotalAmount())
                .build();
        String orderStatus = null;
        try {
            paymentServiceFeignClient.doPayment(paymentRequest);
            orderStatus = "PLACED";
        } catch (Exception e) {
            orderStatus = "PAYMENT_FAILED";
        }

        orderEntity.setOrderStatus(orderStatus);
        orderRepository.save(orderEntity);
        log.info("PaymentServiceFeignClient doPayment done!");

        return orderEntity.getOrderId();
    }

    @Override
    public OrderResponse getOrderDetailByOrderId(long orderId) {
        log.info("OrderService getOrderDetailByOrderId started with orderId: " + orderId);
        OrderEntity orderEntity = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("OrderService getOrderDetailByOrderId NOT FOUND for: " + orderId));

        log.info("OrderService RestCall ProductService getByProductId: " + orderEntity.getProductId());
        OrderResponse.ProductResponse productResponse = restTemplate.getForObject(
                "http://PRODUCT-SERVICE/products/" + orderEntity.getProductId(),
                OrderResponse.ProductResponse.class
        );
        OrderResponse orderResponse = OrderResponse.builder()
                .orderId(orderEntity.getOrderId())
                .totalAmount(orderEntity.getTotalAmount())
                .orderDate(orderEntity.getOrderTime())
                .orderStatus(orderEntity.getOrderStatus())
                .productResponse(productResponse)
                .build();
        log.info("OrderService getOrderDetailByOrderId done!");
        return orderResponse;
    }
}
