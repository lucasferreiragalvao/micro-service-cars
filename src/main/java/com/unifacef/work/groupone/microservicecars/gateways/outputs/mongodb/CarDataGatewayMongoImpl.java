package com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.CarDataGateway;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.documents.CarDocument;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarDataGatewayMongoImpl implements CarDataGateway {

    private final CarRepository carRepository;
    @Override
    public Page<Car> findByPage(Pageable pageable) {
        return carRepository.findAll(pageable).map(CarDocument::toDomain);
    }
}
