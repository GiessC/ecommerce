package com.github.giessc.ecommerce.api.models.domain;

import com.mongodb.lang.Nullable;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@NoArgsConstructor
@Document
public class Item {
    @MongoId
    @Id
    private String itemSlug;
    private String name;
    private String description;

    @jakarta.annotation.Nullable
    @org.springframework.lang.Nullable
    @Nullable
    private String imageLocation;
    private List<String> tags;
    private Double standardPrice;

    public Item(@lombok.NonNull String name, @lombok.NonNull String description, @lombok.NonNull Double standardPrice, @jakarta.annotation.Nullable String imageLocation) {
        this.name = name;
        this.description = description;
        this.standardPrice = standardPrice;
        this.imageLocation = imageLocation;
        this.tags = new ArrayList<>();
        this.itemSlug = this.generateSlug();
    }

    private String generateSlug() {
        String nameSlug = name.toLowerCase(Locale.ROOT).replace(" ", "-");
        UUID uuid = UUID.randomUUID();
        return nameSlug + "-" + uuid;
    }
}
