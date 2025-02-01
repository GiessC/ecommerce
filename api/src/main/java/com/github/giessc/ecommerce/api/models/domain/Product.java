package com.github.giessc.ecommerce.api.models.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Getter
public class Product {
    private final String productSlug;
    private final UUID productId;
    private final String name;
    private final String description;
    private final double standardPrice;
    private final List<String> tags;

    public Product(UUID productId, String name, String description, double standardPrice, List<String> tags) {
        this.productId = productId;
        this.name = name;
        this.productSlug = generateSlug();
        this.description = description;
        this.standardPrice = standardPrice;
        this.tags = tags;
    }

    private String generateSlug() {
        String nameSlug = name.toLowerCase(Locale.ROOT).replace(" ", "-");
        return nameSlug + "-" + productId;
    }

    public Product(String name, String description, double standardPrice, List<String> tags) {
        this.productId = UUID.randomUUID();
        this.name = name;
        this.productSlug = generateSlug();
        this.description = description;
        this.standardPrice = standardPrice;
        this.tags = tags;
    }

    public Product(UUID productId, String name, String description, double standardPrice) {
        this.productId = productId;
        this.name = name;
        this.productSlug = generateSlug();
        this.description = description;
        this.standardPrice = standardPrice;
        this.tags = new ArrayList<>();
    }

    public Product(String name, String description, double standardPrice) {
        this.productId = UUID.randomUUID();
        this.name = name;
        this.productSlug = generateSlug();
        this.description = description;
        this.standardPrice = standardPrice;
        this.tags = new ArrayList<>();
    }
}
