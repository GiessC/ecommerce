package com.github.giessc.ecommerce.api.handlers;

import com.github.giessc.ecommerce.api.models.domain.Product;
import com.github.giessc.ecommerce.api.models.dto.ProductDTO;
import com.github.giessc.ecommerce.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {
    private final ProductService productService;

    public ProductHandler(@Autowired ProductService productService) {
        this.productService = productService;
    }

    public Mono<ServerResponse> createProduct(ServerRequest request) {
        return request.bodyToMono(ProductDTO.class)
            .flatMap(productDTO -> {
                Product product = Product.fromProductDTO(productDTO);
                return this.productService.createProduct(product)
                    .flatMap(createdProduct -> ServerResponse.ok().bodyValue(createdProduct));
            });
    }
}
