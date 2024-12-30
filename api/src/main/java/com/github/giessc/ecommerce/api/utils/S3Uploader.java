package com.github.giessc.ecommerce.api.utils;

import com.github.giessc.ecommerce.api.models.dto.FileResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

import java.time.Duration;

@Component
@AllArgsConstructor
public class S3Uploader implements IFileUploader {
    private final S3Presigner s3Presigner;
    private final String bucketName;

    @Override
    public Mono<FileResponseDTO> getUrlForUpload(FileRequest request) {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
            .bucket(bucketName)
            .key(request.getFilePath())
            .build();
        PutObjectPresignRequest putObjectPresignRequest = PutObjectPresignRequest.builder()
            .signatureDuration(Duration.ofMinutes(10))
            .putObjectRequest(putObjectRequest)
            .build();

        PresignedPutObjectRequest response = s3Presigner.presignPutObject(putObjectPresignRequest);

        FileResponseDTO fileResponseDTO = FileResponseDTO
            .builder()
            .url(response.url().toString())
            .expiration(response.expiration())
            .build();

        return Mono.just(fileResponseDTO);
    }
}
