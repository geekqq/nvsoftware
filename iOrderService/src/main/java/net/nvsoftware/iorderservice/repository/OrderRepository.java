package net.nvsoftware.iorderservice.repository;

import net.nvsoftware.iorderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
