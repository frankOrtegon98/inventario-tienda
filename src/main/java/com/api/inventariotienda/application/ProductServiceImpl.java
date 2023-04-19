package com.api.inventariotienda.application;

import com.api.inventariotienda.domain.model.Product;
import com.api.inventariotienda.infraestructure.adapter.repository.ProductAdapterRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductServiceImpl implements ProductoService{


    private final ProductAdapterRepository repository;

    public ProductServiceImpl(ProductAdapterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<Product> saveProduct(Product product) {
        return this.repository.save(product);
    }

    @Override
    public Mono<Product> getProductByName(String name) {
        return this.repository.findById(name);
    }

    @Override
    public Mono<Product> updateProduct(Product product) {
        return null;
    }

    @Override
    public Mono<Void> deleteProductByName(String name) {
        return null;
    }

    @Override
    public Flux<Product> findAll() {
        return null;
    }
}
