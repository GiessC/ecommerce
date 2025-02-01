package com.github.giessc.ecommerce.api.utils;

import com.github.giessc.ecommerce.api.models.dto.FileResponseDTO;
import reactor.core.publisher.Mono;

public interface IFileDownloader {
    public Mono<FileResponseDTO> getUrlForDownload(FileRequest request);
}
