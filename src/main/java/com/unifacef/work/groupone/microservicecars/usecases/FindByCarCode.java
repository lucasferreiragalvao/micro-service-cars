package com.unifacef.work.groupone.microservicecars.usecases;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.exceptions.MessageKey;
import com.unifacef.work.groupone.microservicecars.exceptions.NotFoundException;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.CarDataGateway;
import com.unifacef.work.groupone.microservicecars.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByCarCode {

    private final CarDataGateway carDataGateway;
    private final MessageUtils messageUtils;

    public Car execute(final String code){
        return carDataGateway.findByCode(code).orElseThrow(() -> new NotFoundException(messageUtils.getMessage(MessageKey.CAR_NOT_FOUND,code)));
    }
}
