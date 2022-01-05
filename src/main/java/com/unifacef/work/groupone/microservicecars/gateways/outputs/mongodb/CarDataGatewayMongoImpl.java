package com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.CarDataGateway;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.documents.CarDocument;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CarDataGatewayMongoImpl implements CarDataGateway {

    private final CarRepository carRepository;

    @Override
    public Car save(final Car car) {
        if(Objects.isNull(car.getCreatedAt())){
            car.setCreatedAt(LocalDateTime.now());
        }
        return carRepository.save(new CarDocument(car)).toDomain();
    }

    @Override
    public Optional<Car> findByCode(String code) {
        return carRepository.findById(code).map(CarDocument::toDomain);
    }

    @Override
    public Optional<Car> findByBoard(String board) {
        return carRepository.findByBoard(board).map(CarDocument::toDomain);
    }

    @Override
    public Optional<Car> findByClassificationCode(String code) {
        return carRepository.findByClassificationId(code).map(CarDocument::toDomain);
    }

    @Override
    public Page<Car> findByPage(Pageable pageable) {
        return carRepository.findAll(pageable).map(CarDocument::toDomain);
    }
}
