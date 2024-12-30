package com.github.giessc.ecommerce.api.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.UUID;

@Document("product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDatabaseDTO {
    private UUID productId;
    @MongoId
    @Id
    private String productSlug;
    private String name;
    private String description;
    private double standardPrice;
    private List<String> tags;
}
