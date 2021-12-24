package com.unifacef.work.groupone.microservicecars.usecases;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.CarDataGateway;
import com.unifacef.work.groupone.microservicecars.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateCar {

    private final CarDataGateway carDataGateway;
    private final MessageUtils messageUtils;

    public Car execute(final Car car){
        log.info("Create car");
        Car saved = carDataGateway.save(car);
        return saved;
    }

}
