package com.unifacef.work.groupone.microservicecars.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {
    CAR_NOT_FOUND("car.not.found"),
    CAR_ALREADY_EXISTS("car.already.exists"),
    CAR_NOTE_EMPTY_CAR_INACTIVE("car.note.empty.car.inactive"),
    CAR_NEW_VALUE_ODOMENTER_LOWER_OLD_VALUE("car.new.value.odomenter.lower.old.value");

    private String key;
}
