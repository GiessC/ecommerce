package com.github.giessc.ecommerce.api.models.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CreateProductDTO {
    private String name;
    private String description;
    private double standardPrice;
    private List<String> tags;
}
