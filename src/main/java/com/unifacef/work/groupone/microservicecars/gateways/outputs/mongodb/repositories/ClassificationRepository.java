package com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.repositories;

import com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.documents.ClassificationDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClassificationRepository extends MongoRepository<ClassificationDocument,String> {

    Optional<ClassificationDocument> findByName(String name);
}
