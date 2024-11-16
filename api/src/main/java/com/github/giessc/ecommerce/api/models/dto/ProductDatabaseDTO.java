package com.github.giessc.ecommerce.api.models.dto;

import com.github.giessc.ecommerce.api.models.domain.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("product")
@Data
@NoArgsConstructor
public class ProductDatabaseDTO {
    @MongoId
    @Id
    private String productSlug;
    private String name;
    private String description;
    private double standardPrice;
    private String imageLocation;
    private String[] tags;

    public static ProductDatabaseDTO fromProduct(Product product) {
        ProductDatabaseDTO productDatabaseDTO = new ProductDatabaseDTO();
        productDatabaseDTO.productSlug = product.getProductSlug();
        productDatabaseDTO.name = product.getName();
        productDatabaseDTO.description = product.getDescription();
        productDatabaseDTO.standardPrice = product.getStandardPrice();
        productDatabaseDTO.imageLocation = product.getImageLocation();
        productDatabaseDTO.tags = product.getTags().toArray(new String[0]);
        return productDatabaseDTO;
    }
}
