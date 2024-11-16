package com.github.giessc.ecommerce.api.services;

import com.github.giessc.ecommerce.api.models.domain.Product;
import com.github.giessc.ecommerce.api.models.dto.ProductDatabaseDTO;
import com.github.giessc.ecommerce.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Mono<Product> createProduct(Product product) {
        ProductDatabaseDTO productDatabaseDTO = ProductDatabaseDTO.fromProduct(product);
        return this.productRepository.save(productDatabaseDTO)
                .flatMap(createdDTO -> Mono.just(Product.fromDatabaseDTO(createdDTO)));
    }
}
