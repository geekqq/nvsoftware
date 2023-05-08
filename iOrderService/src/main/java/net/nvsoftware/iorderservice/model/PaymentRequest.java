package net.nvsoftware.iorderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private long orderId;
    private PaymentMode paymentMode;
    private String referenceNumber;
    private long totalAmount;
    private PaymentResponse paymentResponse;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PaymentResponse {
        private long paymentId;
        private long orderId;
        private String paymentStatus;
        private PaymentMode paymentMode;
        private long totalAmount;
        private Instant paymentDate;
    }

}
