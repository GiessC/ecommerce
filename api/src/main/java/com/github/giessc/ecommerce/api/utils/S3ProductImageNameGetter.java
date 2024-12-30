package com.github.giessc.ecommerce.api.utils;

import com.github.giessc.ecommerce.api.models.dto.ProductDTO;

public class S3ProductImageNameGetter {

    public static final String SUPPORTED_FILE_EXTENSION = ".jpg";

    public String get(ProductDTO productDTO) {
        return productDTO.getProductSlug() + SUPPORTED_FILE_EXTENSION;
    }
}
