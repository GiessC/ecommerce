package com.github.giessc.ecommerce.api.services;

import com.github.giessc.ecommerce.api.models.domain.Item;
import com.github.giessc.ecommerce.api.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(@Autowired ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Mono<Item> createItem(Item item) {
        return this.itemRepository.save(item);
    }
}
