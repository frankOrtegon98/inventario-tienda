package com.api.inventariotienda.infraestructure.adapter.repository;

import com.api.inventariotienda.domain.model.Product;
import com.api.inventariotienda.infraestructure.entity.ProductEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAdapterRepository extends ReactiveMongoRepository<ProductEntity, String>, ReactiveQueryByExampleExecutor<ProductEntity> {
}
