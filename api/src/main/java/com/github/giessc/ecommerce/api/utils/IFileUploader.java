package com.github.giessc.ecommerce.api.utils;

import com.github.giessc.ecommerce.api.models.dto.FileResponseDTO;
import reactor.core.publisher.Mono;

public interface IFileUploader {
    Mono<FileResponseDTO> getUrlForUpload(String fileName);
}
