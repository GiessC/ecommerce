package com.github.giessc.ecommerce.api.utils;

import com.github.giessc.ecommerce.api.models.dto.FileResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedGetObjectRequest;

import java.time.Duration;

@Component
@AllArgsConstructor
public class S3Downloader implements IFileDownloader {
    private final S3Presigner s3Presigner;
    private final String bucketName;

    @Override
    public Mono<FileResponseDTO> getUrlForDownload(FileRequest request) {
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
            .bucket(bucketName)
            .key(request.getFilePath())
            .build();
        GetObjectPresignRequest getObjectPresignRequest = GetObjectPresignRequest.builder()
            .signatureDuration(Duration.ofMinutes(10))
            .getObjectRequest(getObjectRequest)
            .build();

        PresignedGetObjectRequest response = s3Presigner.presignGetObject(getObjectPresignRequest);

        FileResponseDTO fileResponseDTO = FileResponseDTO
            .builder()
            .url(response.url().toString())
            .expiration(response.expiration())
            .build();

        return Mono.just(fileResponseDTO);
    }
}
