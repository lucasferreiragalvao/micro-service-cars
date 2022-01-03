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
public class UpdateCar {
    private final CarDataGateway carDataGateway;
    private final MessageUtils messageUtils;

    public Car execute(final Car car){
        validate(car);
        log.info("Update car. Car code: {}", car.getCode());
        Car oldCar = carDataGateway.findByCode(car.getCode())
                .orElseThrow(() -> new NotFoundException(messageUtils.getMessage(MessageKey.CAR_NOT_FOUND,car.getCode())));

        validateValueOdomenter(car.getOdomenter(),oldCar.getOdomenter());
        car.setCreatedAt(oldCar.getCreatedAt());
        Car saved = carDataGateway.save(car);
        return saved;
    }

    private void validate(Car car){
        validateCarIsNotActiveAndNoteIsNullOrEmpty(car);
        boardIsExist(car);
    }

    private void validateCarIsNotActiveAndNoteIsNullOrEmpty(Car car){
        if(!car.getIsActive() && car.getNote().equals("")){
            log.info("Note cannot be empty when Car Inactive");
            throw new BadRequestException(messageUtils.getMessage(MessageKey.CAR_NOTE_EMPTY_CAR_INACTIVE));
        }
    }

    private void boardIsExist(Car car){
        if(!carDataGateway.findByBoard(car.getBoard()).get().getCode().equals(car.getCode())){
            log.info("Car already exists. Car board: {}",car.getBoard());
            throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.CAR_ALREADY_EXISTS,car.getBoard()));
        }
    }

    private void validateValueOdomenter(Long newOdomenter, Long oldOdomenter){
        if(newOdomenter < oldOdomenter){
            log.info("The new odometer value cannot be lower than the previous one.Current odomenter value {}",oldOdomenter);
            throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.CAR_NEW_VALUE_ODOMENTER_LOWER_OLD_VALUE,oldOdomenter));
        }
    }
}
