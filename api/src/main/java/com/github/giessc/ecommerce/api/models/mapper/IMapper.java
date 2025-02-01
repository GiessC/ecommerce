package com.github.giessc.ecommerce.api.models.mapper;

public interface IMapper<T, R> {
    R map(T t);
}
