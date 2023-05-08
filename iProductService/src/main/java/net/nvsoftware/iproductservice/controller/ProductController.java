package net.nvsoftware.iproductservice.controller;

import lombok.RequiredArgsConstructor;
import net.nvsoftware.iproductservice.model.ProductRequest;
import net.nvsoftware.iproductservice.model.ProductResponse;
import net.nvsoftware.iproductservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody ProductRequest productRequest) {
        long productId = productService.createProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable long productId) {
        ProductResponse productResponse = productService.getProductById(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
    @PutMapping("/reduceQuantity")
    public ResponseEntity<Void> reduceQuantity(@RequestBody long productId, @RequestBody long quantity) {
        productService.reduceQuantity(productId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
