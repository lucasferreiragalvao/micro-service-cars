package com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests;

import com.unifacef.work.groupone.microservicecars.domains.Classification;

public class CreateClassificationRequest extends ClassificationRequest{

    public Classification toDomain(){
        return Classification.builder()
                .name(super.getName())
                .price(super.getPrice())
                .build();
    }
}
