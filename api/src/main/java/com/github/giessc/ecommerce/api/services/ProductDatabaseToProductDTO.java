package com.github.giessc.ecommerce.api.services;

import com.github.giessc.ecommerce.api.models.dto.ProductDTO;
import com.github.giessc.ecommerce.api.models.dto.ProductDatabaseDTO;
import com.github.giessc.ecommerce.api.models.mapper.IMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductDatabaseToProductDTO implements IMapper<ProductDatabaseDTO, ProductDTO> {

    @Override
    public ProductDTO map(ProductDatabaseDTO productDatabaseDTO) {
        return ProductDTO
            .builder()
            .productSlug(productDatabaseDTO.getProductSlug())
            .name(productDatabaseDTO.getName())
            .description(productDatabaseDTO.getDescription())
            .standardPrice(productDatabaseDTO.getStandardPrice())
            .tags(productDatabaseDTO.getTags())
            .build();
    }
}
