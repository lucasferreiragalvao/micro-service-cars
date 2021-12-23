package com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.repositories;

import com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.documents.CarDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<CarDocument,String> {
}
