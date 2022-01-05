package com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests;

import com.unifacef.work.groupone.microservicecars.domains.Classification;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class PathClassificationRequest {

    @Min(value = 1,message = "{required.min}")
    private Double price;

    public Classification toDomain(final String code){
        return Classification.builder()
                .code(code)
                .price(this.price)
                .build();
    }
}
