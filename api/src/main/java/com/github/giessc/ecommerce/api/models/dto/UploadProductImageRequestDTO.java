package com.github.giessc.ecommerce.api.models.dto;

import lombok.Getter;

@Getter
public class UploadProductImageRequestDTO {
    private String fileName;
    private String contentType;
}
