package com.unifacef.work.groupone.microservicecars.usecases;

import com.unifacef.work.groupone.microservicecars.domains.Classification;
import com.unifacef.work.groupone.microservicecars.exceptions.MessageKey;
import com.unifacef.work.groupone.microservicecars.exceptions.NotFoundException;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.ClassificationDataGateway;
import com.unifacef.work.groupone.microservicecars.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByClassificationCode {

    private final ClassificationDataGateway classificationDataGateway;
    private final MessageUtils messageUtils;

    public Classification execute(final String code){
        log.info("Find Classification. Classification code: {}", code);
        return classificationDataGateway.findByCode(code).orElseThrow(() -> new NotFoundException(messageUtils.getMessage(MessageKey.CAR_NOT_FOUND,code)));
    }
}
