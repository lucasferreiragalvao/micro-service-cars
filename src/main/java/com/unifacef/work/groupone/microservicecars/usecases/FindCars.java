package com.unifacef.work.groupone.microservicecars.usecases;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.CarDataGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindCars {

    private final CarDataGateway carDataGateway;

    public Page<Car> execute(final Pageable pageable){
        return carDataGateway.findByPage(pageable);
    }
}
