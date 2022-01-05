package com.unifacef.work.groupone.microservicecars.gateways.inputs.http.responses;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.domains.Classification;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClassificationResponse implements Serializable {

    private static final long serialVersionUID = 6309520552888285200L;

    @ApiModelProperty(position = 0)
    private String code;

    @ApiModelProperty(position = 1)
    private String name;

    @ApiModelProperty(position = 2)
    private Double price;

    public ClassificationResponse(final Classification classification){
       this.code = classification.getCode();
       this.name = classification.getName();
       this.price = classification.getPrice();
    }

}
