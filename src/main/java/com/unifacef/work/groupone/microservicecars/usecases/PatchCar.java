package com.unifacef.work.groupone.microservicecars.usecases;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.domains.Classification;
import com.unifacef.work.groupone.microservicecars.exceptions.BadRequestException;
import com.unifacef.work.groupone.microservicecars.exceptions.MessageKey;
import com.unifacef.work.groupone.microservicecars.exceptions.NotFoundException;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.CarDataGateway;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.ClassificationDataGateway;
import com.unifacef.work.groupone.microservicecars.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class PatchCar {
    private final CarDataGateway carDataGateway;
    private final ClassificationDataGateway classificationDataGateway;
    private final MessageUtils messageUtils;

    public Car execute(final Car car){
        validate(car);
        log.info("Patch car. Car code: {}", car.getCode());
        Car oldCar = carDataGateway.findByCode(car.getCode())
                .orElseThrow(() -> new NotFoundException(messageUtils.getMessage(MessageKey.CAR_NOT_FOUND,car.getCode())));

        validateValueOdomenter(car.getOdomenter(),oldCar.getOdomenter());

        if(car.getIsActive() != null) {
            oldCar.setIsActive(car.getIsActive());
        }

        if(oldCar.getIsActive()){
            oldCar.setNote(null);
        }else if(car.getNote() != null){
            oldCar.setNote(car.getNote());
        }

        if(car.getOdomenter() != null){
            oldCar.setOdomenter(car.getOdomenter());
        }
        if(car.getClassification() != null && car.getClassification().getCode().isEmpty()){
            Classification classification = classificationDataGateway.findByCode(car.getClassification().getCode())
                    .orElseThrow(() -> new NotFoundException(messageUtils.getMessage(MessageKey.CLASSIFICATION_NOT_FOUND,car.getClassification().getCode()))
            );
            oldCar.setClassification(classification);
        }

        if(!Objects.isNull(car.getTankStatus())){
            oldCar.setTankStatus(car.getTankStatus());
        }

        Car saved = carDataGateway.save(oldCar);
        return saved;
    }

    private void validate(Car car){
        validateCarIsNotActiveAndNoteIsNullOrEmpty(car);
    }

    private void validateCarIsNotActiveAndNoteIsNullOrEmpty(Car car){
        if(car.getIsActive() != null && !car.getIsActive() && (car.getNote() == null || car.getNote().equals(""))){
            log.info("Note cannot be empty when Car Inactive");
            throw new BadRequestException(messageUtils.getMessage(MessageKey.CAR_NOTE_EMPTY_CAR_INACTIVE));
        }
    }

    private void validateValueOdomenter(Long newOdomenter, Long oldOdomenter){
        if(newOdomenter < oldOdomenter){
            log.info("The new odometer value cannot be lower than the previous one");
            throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.CAR_NEW_VALUE_ODOMENTER_LOWER_OLD_VALUE,oldOdomenter));
        }
    }


}
