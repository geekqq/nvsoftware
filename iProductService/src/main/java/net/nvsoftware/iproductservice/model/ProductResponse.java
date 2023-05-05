package net.nvsoftware.iproductservice.model;

import lombok.Data;

@Data
public class ProductResponse {
    private String productName;
    private long productPrice;
    private long productQuantity;
}
