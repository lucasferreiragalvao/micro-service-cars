package com.unifacef.work.groupone.microservicecars.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {
    CAR_NOT_FOUND("car.not.found"),
    CAR_ALREADY_EXISTS("car.already.exists"),
    CAR_NOTE_EMPTY_CAR_INACTIVE("car.note.empty.car.inactive"),
    CAR_NEW_VALUE_ODOMENTER_LOWER_OLD_VALUE("car.new.value.odomenter.lower.old.value"),
    CLASSIFICATION_ALREADY_EXISTS("classification.already.exists"),
    CLASSIFICATION_NOT_FOUND("classification.not.found"),
    CLASSIFICATION_ALREADY_WITH_THE_PRICE_INFORMED("classification.already.with.the.price.informed");

    private String key;
}
