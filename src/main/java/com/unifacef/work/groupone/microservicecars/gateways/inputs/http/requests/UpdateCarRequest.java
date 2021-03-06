package com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.domains.Classification;

public class UpdateCarRequest extends CarRequest{
    private static final long serialVersionUID = 8743997776881612716L;

    public Car toDomain(final String code){
        return Car.builder()
                .code(code)
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
