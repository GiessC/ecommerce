package com.github.giessc.ecommerce.api.models.dto;

import lombok.*;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    @Nullable
    private String productSlug;
    private String name;
    private String description;
    private double standardPrice;
    private List<String> tags;

    public ProductDTO(ProductDatabaseDTO productDatabaseDTO) {
        this.name = productDatabaseDTO.getName();
        this.description = productDatabaseDTO.getDescription();
        this.standardPrice = productDatabaseDTO.getStandardPrice();
        this.tags = productDatabaseDTO.getTags();
    }
}
