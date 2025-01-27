package com.github.giessc.ecommerce.api.handlers;

import com.github.giessc.ecommerce.api.models.domain.Product;
import com.github.giessc.ecommerce.api.models.dto.CreateProductDTO;
import com.github.giessc.ecommerce.api.models.dto.UploadProductImageRequestDTO;
import com.github.giessc.ecommerce.api.models.mapper.CreateProductDTOToProduct;
import com.github.giessc.ecommerce.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ProductHandler {
    private final ProductService productService;
    private final CreateProductDTOToProduct createProductDTOToProductMapper;

    public ProductHandler(@Autowired ProductService productService, @Autowired CreateProductDTOToProduct mapper) {
        this.productService = productService;
        this.createProductDTOToProductMapper = mapper;
    }

    public Mono<ServerResponse> createProduct(ServerRequest request) {
        return request.bodyToMono(CreateProductDTO.class)
            .flatMap(createProductDTO -> {
                Product product = createProductDTOToProductMapper.map(createProductDTO);
                return this.productService.createProduct(product)
                    .flatMap(createdProduct -> ServerResponse.ok().bodyValue(createdProduct));
            });
    }

    public Mono<ServerResponse> uploadProductImage(ServerRequest request) {
        return request.bodyToMono(UploadProductImageRequestDTO.class)
            .flatMap(uploadProductImageRequestDTO -> this.productService.uploadProductImage(uploadProductImageRequestDTO)
                .flatMap(createdProduct -> ServerResponse.ok().bodyValue(createdProduct))
            );
    }
}
