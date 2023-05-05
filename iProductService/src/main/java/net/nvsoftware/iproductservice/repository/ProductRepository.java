package net.nvsoftware.iproductservice.repository;

import net.nvsoftware.iproductservice.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
