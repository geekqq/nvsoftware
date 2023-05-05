package net.nvsoftware.iproductservice.model;

import lombok.Data;

@Data
public class ProductRequest {
    private String productName;
    private long productPrice;
    private long productQuantity;
}
