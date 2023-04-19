package com.api.inventariotienda.domain.gateway;

import com.api.inventariotienda.domain.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository {
    Mono<Product> saveProduct(Product product);
    Mono<Product> getProductByName(String name);
    Mono<Product> updateProduct(Product product);
    Mono<Void> deleteProductByName(String name);
    Flux<Product> findAll();
}
