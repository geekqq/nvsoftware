package net.nvsoftware.iorderservice.service;

import lombok.extern.log4j.Log4j2;
import net.nvsoftware.iorderservice.entity.OrderEntity;
import net.nvsoftware.iorderservice.model.OrderRequest;
import net.nvsoftware.iorderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
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
        //Call PaymentService to charge paymentMode, mark order COMPLETED if success, otherwise mark CANCELLED

        return 0;
    }
}
