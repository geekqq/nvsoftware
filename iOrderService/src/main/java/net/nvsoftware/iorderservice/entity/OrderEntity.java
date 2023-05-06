package net.nvsoftware.iorderservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.nvsoftware.iorderservice.model.PaymentMode;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    private long productId;
    private long orderQuantity;
    private long totalAmount;
    private PaymentMode paymentMode;
    private Instant orderTime;
    private String orderStatus;
}
