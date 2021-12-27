package com.unifacef.work.groupone.microservicecars.gateways.inputs.http.responses;


import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.domains.Classification;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CarResponse implements Serializable {
    private static final long serialVersionUID = 9189520552888285200L;

    @ApiModelProperty(position = 0)
    private String code;

    @ApiModelProperty(position = 1)
    private int year;

    @ApiModelProperty(position = 2)
    private String color;

    @ApiModelProperty(position = 3)
    private Classification classification;

    @ApiModelProperty(position = 4)
    private BrandResponse brand;

    @ApiModelProperty(position = 5)
    private String model;

    @ApiModelProperty(position = 6)
    private String name;

    @ApiModelProperty(position = 6)
    private String board;

    @ApiModelProperty(position = 7)
    private Double tankSize;

    @ApiModelProperty(position = 8)
    private Boolean isActive;

    @ApiModelProperty(position = 9)
    private String note;

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
        this.isActive = car.getIsActive();
        this.note = car.getNote();
    }
}
