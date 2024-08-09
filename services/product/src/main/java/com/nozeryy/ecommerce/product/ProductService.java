package com.nozeryy.ecommerce.product;

import com.nozeryy.ecommerce.exception.ProductNotFoundException;
import com.nozeryy.ecommerce.exception.ProductPurchaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Integer createProduct(ProductRequest productRequest) {
        var product = productMapper.toProduct(productRequest);
        return productRepository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> requests) {
        var productIds = requests.stream()
                .map(ProductPurchaseRequest::productId)
                .toList();
        var storedProduct = productRepository.findAllByIdInOrderById(productIds);
        if(productIds.size() != storedProduct.size()){
            throw new ProductPurchaseException("One or more product does not exists");
        }

        var storedRequest = requests
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();

        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for(int i=0; i<storedProduct.size(); i++){
            var product = storedProduct.get(i);
            var productRequest = storedRequest.get(i);
            if(product.getAvailableQuantity() < productRequest.quantity()){
                throw new ProductPurchaseException("Insufficient stock quantity for product ID " + productRequest.productId());
            }

            var updatedAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(updatedAvailableQuantity);
            productRepository.save(product);
            purchasedProducts.add(productMapper.toProductPurchaseResponse(product, productRequest.quantity()));
        }

        return null;
    }

    public ProductResponse findProductById(Integer id) {
        return productRepository.findById(id)
                .map(productMapper::toProductResponse)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id of " + id));
    }

    public List<ProductResponse> findAllProduct() {
            return productRepository.findAll()
                    .stream()
                    .map(productMapper::toProductResponse)
                    .collect(Collectors.toList());
    }
}
