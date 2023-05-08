package net.nvsoftware.ipaymentservice.service;

import net.nvsoftware.ipaymentservice.model.PaymentRequest;

public interface PaymentService {
    long doPayment(PaymentRequest paymentRequest);
}
