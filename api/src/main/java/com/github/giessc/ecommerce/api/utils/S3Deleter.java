package com.github.giessc.ecommerce.api.utils;


import com.github.giessc.ecommerce.api.exceptions.FileDeleterException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;

@Component
@AllArgsConstructor
public class S3Deleter implements IFileDeleter {
    private final String bucketName;
    private final S3Client s3Client;

    @Override
    public void delete(FileRequest request) throws FileDeleterException {
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
            .bucket(bucketName)
            .key(request.getFileName())
            .build();

        DeleteObjectResponse response = s3Client.deleteObject(deleteObjectRequest);

        throwIfUnsuccessful(response);
    }

    private void throwIfUnsuccessful(DeleteObjectResponse response) throws FileDeleterException {
        if (response.sdkHttpResponse().isSuccessful()) {
            return;
        }
        throw new FileDeleterException("Failed to delete file from S3: " + response.sdkHttpResponse().statusText());
    }
}
