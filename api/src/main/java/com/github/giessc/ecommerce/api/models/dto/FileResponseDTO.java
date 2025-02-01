package com.github.giessc.ecommerce.api.models.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class FileResponseDTO {
    public String url;
    public Instant expiration;
    public String fileName;
}
