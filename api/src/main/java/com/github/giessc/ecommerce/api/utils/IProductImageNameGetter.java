package com.github.giessc.ecommerce.api.utils;

import com.github.giessc.ecommerce.api.models.dto.ProductDTO;

public interface IProductImageNameGetter {

    String get(ProductDTO productDTO);
}
