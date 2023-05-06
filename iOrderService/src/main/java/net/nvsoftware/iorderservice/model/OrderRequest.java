package net.nvsoftware.iorderservice.model;


import lombok.Data;

import java.time.Instant;

@Data
public class OrderRequest {
    private long productId;
    private long orderQuantity;
    private long totalAmount;
    private PaymentMode paymentMode;
    private Instant orderTime;
}
