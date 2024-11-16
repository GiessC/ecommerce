package com.github.giessc.ecommerce.api.repositories;

import com.github.giessc.ecommerce.api.models.dto.ProductDatabaseDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends ReactiveMongoRepository<ProductDatabaseDTO, UUID> {
}
