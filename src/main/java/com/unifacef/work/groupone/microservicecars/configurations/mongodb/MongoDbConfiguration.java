package com.unifacef.work.groupone.microservicecars.configurations.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb"})
public class MongoDbConfiguration {
    @Autowired
    private MappingMongoConverter mappingMongoConverter;

    @PostConstruct
    public void setUpMongoEscapeCharacterConversion(){
        mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
    }

}
