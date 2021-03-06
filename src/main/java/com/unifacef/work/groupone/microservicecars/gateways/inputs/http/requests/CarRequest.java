package com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests;

import com.unifacef.work.groupone.microservicecars.domains.Classification;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public abstract class CarRequest implements Serializable {

    private static final long serialVersionUID = 3475925051912991191L;

    @ApiModelProperty(position = 1)
    @Valid
    private BrandRequest brand;

    @ApiModelProperty(position = 2)
    @NotNull(message = "{required.field}")
    private String codeclassification;

    @ApiModelProperty(position = 3)
    @NotNull(message = "{required.field}")
    private String name;

    @ApiModelProperty(position = 4)
    @NotNull(message = "{required.field}")
    private String board;

    @ApiModelProperty(position = 5)
    @NotNull(message = "{required.field}")
    @Min(value = 1900,message = "{required.min}")
    private int year;

    @ApiModelProperty(position = 6)
    @NotNull(message = "{required.field}")
    private String model;

    @ApiModelProperty(position = 7)
    @NotNull(message = "{required.field}")
    private String color;

    @ApiModelProperty(position = 8)
    @NotNull(message = "{required.field}")
    @Min(value = 1,message = "{required.min}")
    private Double tankSize;

    @ApiModelProperty(position = 9)
    @NotNull(message = "{required.field}")
    private Long odomenter;

    @ApiModelProperty(position = 10)
    private Boolean isActive;

    @ApiModelProperty(position = 11)
    private String note;


}
