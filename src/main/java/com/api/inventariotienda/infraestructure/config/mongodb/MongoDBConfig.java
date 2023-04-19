package com.api.inventariotienda.infraestructure.config.mongodb;

import com.mongodb.ConnectionString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;

@Configuration
public class MongoDBConfig {

    @Primary
    @Bean(name = "integrationProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.uri")
    public MongoProperties getIntegrationProperties() {
        return new MongoProperties();
    }

    @Primary
    @Bean("integrationDatabaseFactory")
    public ReactiveMongoDatabaseFactory integrationDatabaseFactory(
            @Qualifier("integrationProperties") MongoProperties properties
    ) {
        return new SimpleReactiveMongoDatabaseFactory(new ConnectionString(properties.getUri()));
    }

    @Primary
    @Bean(name = "integrationMongoTemplate")
    public ReactiveMongoTemplate integrationReactiveMongoTemplate(
            @Qualifier("integrationDatabaseFactory") ReactiveMongoDatabaseFactory databaseFactory
    ){
        return new ReactiveMongoTemplate(databaseFactory);
    }
}
