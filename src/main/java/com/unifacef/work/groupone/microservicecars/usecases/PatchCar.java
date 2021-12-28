package com.unifacef.work.groupone.microservicecars.usecases;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.exceptions.BadRequestException;
import com.unifacef.work.groupone.microservicecars.exceptions.MessageKey;
import com.unifacef.work.groupone.microservicecars.exceptions.NotFoundException;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.CarDataGateway;
import com.unifacef.work.groupone.microservicecars.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PatchCar {
    private final CarDataGateway carDataGateway;
    private final MessageUtils messageUtils;

    public Car execute(final Car car){
        validate(car);
        log.info("Patch car. Car code: {}", car.getCode());
        Car oldCar = carDataGateway.findByCode(car.getCode())
                .orElseThrow(() -> new NotFoundException(messageUtils.getMessage(MessageKey.CAR_NOT_FOUND,car.getCode())));

        if(car.getIsActive() != null) {
            oldCar.setIsActive(car.getIsActive());
        }

        if(oldCar.getIsActive()){
            oldCar.setNote(null);
        }else if(car.getNote() != null){
            oldCar.setNote(car.getNote());
        }

        Car saved = carDataGateway.save(oldCar);
        return saved;
    }

    private void validate(Car car){
        if(car.getIsActive() != null && !car.getIsActive() && (car.getNote() == null || car.getNote().equals(""))){
            log.info("Note cannot be empty when Car Inactive");
            throw new BadRequestException(messageUtils.getMessage(MessageKey.CAR_NOTE_EMPTY_CAR_INACTIVE));
        }
    }
}
