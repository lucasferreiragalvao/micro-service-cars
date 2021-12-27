package com.unifacef.work.groupone.microservicecars.usecases;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.CarDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindCars {

    private final CarDataGateway carDataGateway;

    public Page<Car> execute(final Pageable pageable){
        log.info("Find cars. Page: {}, Size: {}", pageable.getPageNumber(),pageable.getPageSize());
        return carDataGateway.findByPage(pageable);
    }
}
