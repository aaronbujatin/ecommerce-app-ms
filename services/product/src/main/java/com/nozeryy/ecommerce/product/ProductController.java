package com.nozeryy.ecommerce.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> createProduct(@RequestBody @Valid ProductRequest productRequest){
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequest> requests){
        return ResponseEntity.ok(productService.purchaseProducts(requests));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("product-id") Integer id){
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProduct(){
        return ResponseEntity.ok(productService.findAllProduct());
    }
}
