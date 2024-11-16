package com.github.giessc.ecommerce.api.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @jakarta.annotation.Nullable
    @Nullable
    private String productSlug;
    private String name;
    private String description;
    private double standardPrice;
    private String imageLocation;
    private List<String> tags;

    public ProductDTO(ProductDatabaseDTO productDatabaseDTO) {
        this.name = productDatabaseDTO.getName();
        this.description = productDatabaseDTO.getDescription();
        this.standardPrice = productDatabaseDTO.getStandardPrice();
        this.imageLocation = productDatabaseDTO.getImageLocation();
        this.tags = List.of(productDatabaseDTO.getTags());
    }
}
