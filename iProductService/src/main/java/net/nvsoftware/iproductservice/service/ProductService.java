package net.nvsoftware.iproductservice.service;

import net.nvsoftware.iproductservice.model.ProductRequest;
import net.nvsoftware.iproductservice.model.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    long createProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);
}
