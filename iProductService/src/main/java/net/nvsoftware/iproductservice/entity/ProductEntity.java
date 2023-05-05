package net.nvsoftware.iproductservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    //@Column(name="" 数据库里的名字)
    private String productName;
    private long price;

    private long productQuantity;
}
