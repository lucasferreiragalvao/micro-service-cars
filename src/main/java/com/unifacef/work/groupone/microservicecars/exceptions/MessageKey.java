package com.unifacef.work.groupone.microservicecars.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {
    CAR_NOT_FOUND("car.not.found"),
    CAR_ALREADY_EXISTS("car.already.exists");

    private String key;
}
