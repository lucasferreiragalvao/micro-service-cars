package com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public abstract class ClassificationRequest implements Serializable {

    private static final long serialVersionUID = 3885925051912991191L;

    @ApiModelProperty(position = 0)
    @NotNull(message = "{required.field}")
    private String name;

    @ApiModelProperty(position = 1)
    @NotNull(message = "{required.field}")
    @Min(value = 1,message = "{required.min}")
    private Double price;

}
