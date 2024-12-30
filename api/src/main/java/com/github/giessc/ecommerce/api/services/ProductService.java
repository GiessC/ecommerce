package com.github.giessc.ecommerce.api.services;

import com.github.giessc.ecommerce.api.models.domain.Product;
import com.github.giessc.ecommerce.api.models.dto.ProductDTO;
import com.github.giessc.ecommerce.api.models.dto.ProductDatabaseDTO;
import com.github.giessc.ecommerce.api.models.mapper.ProductToProductDatabaseDTO;
import com.github.giessc.ecommerce.api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductToProductDatabaseDTO productToProductDatabaseDTO;
    private final ProductDatabaseToProductDTO productDatabaseToProductDTO;

    public ProductService(
        @Autowired ProductRepository productRepository,
        @Autowired ProductToProductDatabaseDTO mapper,
        @Autowired ProductDatabaseToProductDTO productDatabaseToProductDTO
    ) {
        this.productRepository = productRepository;
        this.productToProductDatabaseDTO = mapper;
        this.productDatabaseToProductDTO = productDatabaseToProductDTO;
    }

    public Mono<ProductDTO> createProduct(Product product) {
        ProductDatabaseDTO productDatabaseDTO = productToProductDatabaseDTO.map(product);
        return this.productRepository.save(productDatabaseDTO)
                .flatMap(createdDTO -> Mono.just(productDatabaseToProductDTO.map(createdDTO)));
    }
}
