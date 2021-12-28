package com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PatchCarRequest implements Serializable {

    private static final long serialVersionUID = 3875925051912991191L;

    @ApiModelProperty(position = 1)
    private Boolean isActive;

    @ApiModelProperty(position = 2)
    private String note;

    public Car toDomain(final String code){
        return Car.builder()
                .code(code)
                .isActive(this.isActive)
                .note(this.note)
                .build();
    }
}
