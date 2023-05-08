package net.nvsoftware.ipaymentservice.repository;

import net.nvsoftware.ipaymentservice.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
