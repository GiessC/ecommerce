package com.github.giessc.ecommerce.api.repositories;

import com.github.giessc.ecommerce.api.models.domain.Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends ReactiveMongoRepository<Item, UUID> {
}
