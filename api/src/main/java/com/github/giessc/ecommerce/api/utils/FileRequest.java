package com.github.giessc.ecommerce.api.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class FileRequest {
    private final String fileName;
}
