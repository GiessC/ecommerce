package com.github.giessc.ecommerce.api.utils;

public enum Routes {
    PRODUCT("/products"),
    UPLOAD_PRODUCT_IMAGE("/products/image");

    private final String route;

    Routes(String route) {
        this.route = route;
    }

    public String get() {
        return this.route;
    }

    @Override
    public String toString() {
        return this.route;
    }
}
