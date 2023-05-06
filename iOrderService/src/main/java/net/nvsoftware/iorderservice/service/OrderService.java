package net.nvsoftware.iorderservice.service;

import net.nvsoftware.iorderservice.model.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
