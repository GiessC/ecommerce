package com.github.giessc.ecommerce.api.models.mapper;

import com.github.giessc.ecommerce.api.models.domain.Product;
import com.github.giessc.ecommerce.api.models.dto.CreateProductDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateProductDTOToProduct implements IMapper<CreateProductDTO, Product> {

    @Override
    public Product map(CreateProductDTO createProductDTO) {
        return new Product(
            createProductDTO.getName(),
            createProductDTO.getDescription(),
            createProductDTO.getStandardPrice(),
            createProductDTO.getTags()
        );
    }
}
