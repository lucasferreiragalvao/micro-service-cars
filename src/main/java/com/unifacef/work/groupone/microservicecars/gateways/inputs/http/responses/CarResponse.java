package com.unifacef.work.groupone.microservicecars.gateways.inputs.http.responses;


import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.domains.Classification;
import lombok.Data;

import java.io.Serializable;

@Data
public class CarResponse implements Serializable {
    private static final long serialVersionUID = 9189520552888285200L;

    private String code;
    private int year;
    private String color;
    private Classification classification;
    private BrandResponse brand;
    private String model;
    private String name;
    private String board;
    private Double tankSize;

    public CarResponse(final Car car){
        this.code = car.getCode();
        this.year = car.getYear();
        this.color = car.getColor();
        this.classification = car.getClassification();
        this.brand = new BrandResponse(car.getBrand());
        this.model = car.getModel();
        this.name = car.getName();
        this.board = car.getBoard();
        this.tankSize = car.getTankSize();
    }
}
