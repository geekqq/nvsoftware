package net.nvsoftware.iorderservice.controller;

import net.nvsoftware.iorderservice.model.OrderRequest;
import net.nvsoftware.iorderservice.model.OrderResponse;
import net.nvsoftware.iorderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest) {
        long orderId = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(orderId, HttpStatus.OK);
    }
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderDetailByOrderId(@PathVariable long orderId) {
        OrderResponse orderResponse = orderService.getOrderDetailByOrderId(orderId);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }
}
