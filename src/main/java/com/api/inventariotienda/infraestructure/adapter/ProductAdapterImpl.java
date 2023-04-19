package com.api.inventariotienda.infraestructure.adapter;

import com.api.inventariotienda.domain.model.Product;
import com.api.inventariotienda.domain.gateway.ProductRepository;
import com.api.inventariotienda.infraestructure.adapter.repository.ProductAdapterRepository;
import com.api.inventariotienda.infraestructure.entity.ProductEntity;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductAdapterImpl implements ProductRepository {

    private final ProductAdapterRepository repository;
    @Qualifier("integrationMongoTemplate")
    private final ReactiveMongoTemplate mongoTemplate;

    private ObjectMapper objectMapper;

    @Autowired
    public ProductAdapterImpl(ProductAdapterRepository repository,
                              @Qualifier("integrationMongoTemplate") ReactiveMongoTemplate mongoTemplate,
                              ObjectMapper objectMapper) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public Mono<Product> saveProduct(Product product) {
        return Mono.just(product)
                .map(productMono -> objectMapper.mapBuilder(productMono, ProductEntity.ProductEntityBuilder.class).build())
                .flatMap(repository::save)
                .onErrorResume(error -> Mono.error(new RuntimeException("No se pudo guardar el registo: " + error)))
                .map(productEntity -> objectMapper.mapBuilder(productEntity, Product.ProductBuilder.class).build());
    }

    @Override
    public Mono<Product> getProductByName(String name) {
        final Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, ProductEntity.class)
                .switchIfEmpty(Mono.error(new Exception("Registro no encontrado")))
                .onErrorResume(error -> Mono.error(new RuntimeException("Registro no encontrado:" + error)))
                .map(productEntity -> objectMapper.mapBuilder(productEntity, Product.ProductBuilder.class).build());
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
