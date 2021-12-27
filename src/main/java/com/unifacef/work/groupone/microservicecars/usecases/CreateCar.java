package com.unifacef.work.groupone.microservicecars.usecases;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.exceptions.BadRequestException;
import com.unifacef.work.groupone.microservicecars.exceptions.MessageKey;
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
        validate(car);
        log.info("Create car");
        Car saved = carDataGateway.save(car);
        return saved;
    }

    private void validate(Car car){
        if(!car.getIsActive() && car.getNote().equals("")){
            log.info("Note cannot be empty when Car Inactive");
            throw new BadRequestException(messageUtils.getMessage(MessageKey.CAR_NOTE_EMPTY_CAR_INACTIVE));
        }
    }
}
