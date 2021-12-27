package com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests;

import com.unifacef.work.groupone.microservicecars.domains.Car;

public class UpdateCarRequest extends CarRequest{
    private static final long serialVersionUID = 8743997776881612716L;

    public Car toDomain(final String code){
        return Car.builder()
                .code(code)
                .brand(super.getBrand().toDomain())
                .classification(super.getClassification())
                .name(super.getName())
                .board(super.getBoard())
                .year(super.getYear())
                .model(super.getModel())
                .color(super.getColor())
                .tankSize(super.getTankSize())
                .isActive(super.getIsActive())
                .note(super.getNote())
                .build();
    }
}
