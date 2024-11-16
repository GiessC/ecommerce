package com.github.giessc.ecommerce.api.handlers;

import com.github.giessc.ecommerce.api.models.domain.Item;
import com.github.giessc.ecommerce.api.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ItemHandler {
    private final ItemService itemService;

    public ItemHandler(@Autowired ItemService itemService) {
        this.itemService = itemService;
    }

    public Mono<ServerResponse> createItem(ServerRequest request) {
        Item temp = new Item("test", "test", 1.0, "test");
        return this.itemService.createItem(temp)
            .flatMap(createdItem -> ServerResponse.ok().bodyValue(createdItem));
    }
}
