package com.unifacef.work.groupone.microservicecars.gateways.outputs;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CarDataGateway {

    Car save(Car car);

    Optional<Car> findByCode(String code);

    Optional<Car> findByBoard(String board);

    Optional<Car> findByClassificationCode(String code);

    Page<Car> findByPage(Pageable pageable);
}
