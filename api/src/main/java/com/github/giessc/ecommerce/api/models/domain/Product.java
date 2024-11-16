package com.github.giessc.ecommerce.api.models.domain;

import com.github.giessc.ecommerce.api.models.dto.ProductDTO;
import com.github.giessc.ecommerce.api.models.dto.ProductDatabaseDTO;
import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productSlug;
    private String name;
    private String description;

    @jakarta.annotation.Nullable
    @org.springframework.lang.Nullable
    @Nullable
    private String imageLocation;
    private List<String> tags;
    private double standardPrice;

    public static Product fromDatabaseDTO(ProductDatabaseDTO createdDTO) {
        return new Product(
            generateSlugIfEmpty(createdDTO.getProductSlug(), createdDTO.getName()),
            createdDTO.getName(),
            createdDTO.getDescription(),
            createdDTO.getImageLocation(),
            Arrays.stream(createdDTO.getTags()).toList(),
            createdDTO.getStandardPrice()
        );
    }

    private static String generateSlugIfEmpty(String slug, String name) {
        if (slug == null || slug.isEmpty()) {
            return generateSlug(name);
        }
        return slug;
    }

    private static String generateSlug(String name) {
        String nameSlug = name.toLowerCase(Locale.ROOT).replace(" ", "-");
        UUID uuid = UUID.randomUUID();
        return nameSlug + "-" + uuid;
    }

    public static Product fromProductDTO(ProductDTO productDTO) {
        return new Product(
            generateSlugIfEmpty(productDTO.getProductSlug(), productDTO.getName()),
            productDTO.getName(),
            productDTO.getDescription(),
            productDTO.getImageLocation(),
            productDTO.getTags(),
            productDTO.getStandardPrice()
        );
    }
}
