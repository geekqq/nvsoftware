package net.nvsoftware.ipaymentservice.controller;

import net.nvsoftware.ipaymentservice.model.PaymentRequest;
import net.nvsoftware.ipaymentservice.model.PaymentResponse;
import net.nvsoftware.ipaymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @PostMapping("doPayment")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest) {
        long paymentId = paymentService.doPayment(paymentRequest);
        return new ResponseEntity<>(paymentId, HttpStatus.OK);
    }

    @GetMapping("/orderId")
    public ResponseEntity<PaymentResponse> getPaymentByOrderId(@PathVariable long orderId){
        PaymentResponse paymentResponse = paymentService.getPaymentByOrderId(orderId);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }
}
