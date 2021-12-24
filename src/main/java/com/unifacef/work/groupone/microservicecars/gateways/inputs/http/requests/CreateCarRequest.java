package com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests;

import com.unifacef.work.groupone.microservicecars.domains.Car;

public class CreateCarRequest extends CarRequest{
    public Car toDomain(){
        return Car.builder()
                .brand(super.getBrand().toDomain())
                .classification(super.getClassification())
                .name(super.getName())
                .board(super.getBoard())
                .year(super.getYear())
                .model(super.getModel())
                .color(super.getColor())
                .tankSize(super.getTankSize())
                .build();
    }
}
