package net.nvsoftware.ipaymentservice.service;

import net.nvsoftware.ipaymentservice.model.PaymentRequest;
import net.nvsoftware.ipaymentservice.model.PaymentResponse;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentByOrderId(long orderId);
}
