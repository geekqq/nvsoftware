package net.nvsoftware.ipaymentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@Builder
@Table(name = "Payment_Table")
@AllArgsConstructor
@NoArgsConstructor
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long paymentId;
    private long orderId;
    private String paymentMode;
    private String referenceNumber;
    private long totalAmount;
    private Instant paymentDate;
    private String paymentStatus;
}
