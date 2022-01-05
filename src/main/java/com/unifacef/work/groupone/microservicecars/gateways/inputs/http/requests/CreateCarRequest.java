package com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.domains.Classification;

public class CreateCarRequest extends CarRequest{
    public Car toDomain(){
        return Car.builder()
                .brand(super.getBrand().toDomain())
                .classification(Classification.builder().code(super.getCodeclassification()).build())
                .name(super.getName())
                .board(super.getBoard())
                .year(super.getYear())
                .model(super.getModel())
                .color(super.getColor())
                .tankSize(super.getTankSize())
                .odomenter(super.getOdomenter())
                .isActive(super.getIsActive())
                .note(super.getNote())
                .build();
    }
}
