package net.nvsoftware.iorderservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private long productId;
    private long orderQuantity;
    private long totalAmount;
    private PaymentMode paymentMode;
    private Instant orderTime;
}
