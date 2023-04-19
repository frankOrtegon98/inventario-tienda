package com.api.inventariotienda.application;

import com.api.inventariotienda.domain.model.Product;
import com.api.inventariotienda.infraestructure.entity.ProductEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductoService {

    Mono<Product> saveProduct(Product product);
    Mono<Product> getProductByName(String name);
    Mono<Product> updateProduct(Product product);
    Mono<Void> deleteProductByName(String name);
    Flux<Product> findAll();
}
