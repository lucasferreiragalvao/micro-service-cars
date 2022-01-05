package com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.repositories;

import com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.documents.CarDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CarRepository extends MongoRepository<CarDocument,String> {
    Optional<CarDocument> findByBoard(String board);
    Optional<CarDocument> findByClassificationId(String code);
}
