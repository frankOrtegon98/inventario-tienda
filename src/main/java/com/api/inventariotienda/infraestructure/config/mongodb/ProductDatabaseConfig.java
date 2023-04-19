package com.api.inventariotienda.infraestructure.config.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@EnableReactiveMongoRepositories(
        basePackages = { "com.api.inventariotienda.infraestructure.adapter.repository" },
        reactiveMongoTemplateRef = "integrationMongoTemplate"
)
public class ProductDatabaseConfig {
}
