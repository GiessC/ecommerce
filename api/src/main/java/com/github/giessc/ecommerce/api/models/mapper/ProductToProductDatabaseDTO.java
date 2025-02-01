package com.github.giessc.ecommerce.api.models.mapper;

import com.github.giessc.ecommerce.api.models.domain.Product;
import com.github.giessc.ecommerce.api.models.dto.ProductDatabaseDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductToProductDatabaseDTO implements IMapper<Product, ProductDatabaseDTO> {
    @Override
    public ProductDatabaseDTO map(Product product) {
        return ProductDatabaseDTO
            .builder()
            .productId(product.getProductId())
            .name(product.getName())
            .description(product.getDescription())
            .standardPrice(product.getStandardPrice())
            .tags(product.getTags())
            .build();
    }
}
