package com.unifacef.work.groupone.microservicecars.usecases;

import com.unifacef.work.groupone.microservicecars.domains.Classification;
import com.unifacef.work.groupone.microservicecars.exceptions.MessageKey;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.ClassificationDataGateway;
import com.unifacef.work.groupone.microservicecars.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateClassification {

    private final ClassificationDataGateway classificationDataGateway;
    private final MessageUtils messageUtils;

    public Classification execute(final Classification classification){
        validate(classification);
        log.info("Create Classification");
        return classificationDataGateway.save(classification);
    }

    private void validate(Classification classification){
        validIsNameExists(classification);
    }

    private void validIsNameExists(Classification classification){
        if(!classificationDataGateway.findByName(classification.getName()).isEmpty()){
            throw new IllegalArgumentException(messageUtils.getMessage(MessageKey.CLASSIFICATION_ALREADY_EXISTS,classification.getName()));
        }
    }
}
