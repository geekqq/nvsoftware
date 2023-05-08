package net.nvsoftware.iorderservice.service;

import net.nvsoftware.iorderservice.model.OrderRequest;
import net.nvsoftware.iorderservice.model.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetailByOrderId(long orderId);
}
