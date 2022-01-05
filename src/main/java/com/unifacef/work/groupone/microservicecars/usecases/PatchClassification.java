package com.unifacef.work.groupone.microservicecars.usecases;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.domains.Classification;
import com.unifacef.work.groupone.microservicecars.exceptions.MessageKey;
import com.unifacef.work.groupone.microservicecars.exceptions.NotFoundException;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.CarDataGateway;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.ClassificationDataGateway;
import com.unifacef.work.groupone.microservicecars.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class PatchClassification {

    private final ClassificationDataGateway classificationDataGateway;
    private final CarDataGateway carDataGateway;
    private final MessageUtils messageUtils;

    public Classification execute(final Classification classification){
        Classification oldClassification = classificationDataGateway.findByCode(classification.getCode())
                .orElseThrow(() -> new NotFoundException(messageUtils.getMessage(MessageKey.CLASSIFICATION_NOT_FOUND,classification.getCode())));

        if(classification.getPrice() != null && oldClassification.getPrice().equals(classification.getPrice())){
           throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.CLASSIFICATION_ALREADY_WITH_THE_PRICE_INFORMED,classification.getCode()));
        }

        oldClassification.setPrice(classification.getPrice());
        Classification saved = classificationDataGateway.save(oldClassification);

        carDataGateway.findByClassificationCode(classification.getCode())
             .map(car -> {
                    car.getClassification().setPrice(classification.getPrice());
                    return carDataGateway.save(car);
             });

        return saved;
    }
}
