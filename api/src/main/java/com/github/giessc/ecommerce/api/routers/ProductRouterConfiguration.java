package com.github.giessc.ecommerce.api.routers;

import com.github.giessc.ecommerce.api.handlers.ProductHandler;
import com.github.giessc.ecommerce.api.utils.Routes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration(proxyBeanMethods = false)
public class ProductRouterConfiguration {
    private static final RequestPredicate ACCEPT_JSON = accept(MediaType.APPLICATION_JSON);

    @Bean
    public RouterFunction<ServerResponse> productRouter(ProductHandler productHandler) {
        return route()
            .POST(Routes.PRODUCT.get(), ACCEPT_JSON, productHandler::createProduct)
            .POST(Routes.UPLOAD_PRODUCT_IMAGE.get(), ACCEPT_JSON, productHandler::uploadProductImage)
            .build();
    }
}
