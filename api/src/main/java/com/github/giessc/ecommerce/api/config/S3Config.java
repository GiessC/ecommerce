package com.github.giessc.ecommerce.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
public class S3Config {
    @Value("${aws.s3.bucketName}")
    private String bucketName;

    @Bean
    public S3Presigner s3Presigner() {
        return S3Presigner.builder().build();
    }

    @Bean
    public S3Client s3Client() {
        return S3Client.builder().build();
    }

    @Bean
    public String bucketName() {
        return bucketName;
    }
}
