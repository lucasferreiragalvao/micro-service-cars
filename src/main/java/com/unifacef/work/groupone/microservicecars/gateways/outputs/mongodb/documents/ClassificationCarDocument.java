package com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.documents;

import com.unifacef.work.groupone.microservicecars.domains.Brand;
import com.unifacef.work.groupone.microservicecars.domains.Classification;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClassificationCarDocument {
    private String id;
    private String name;
    private Double price;

    public ClassificationCarDocument(final Classification classification){
        this.id = classification.getCode();
        this.name = classification.getName();
        this.price = classification.getPrice();
    }

    public Classification toDomain(){
        return Classification.builder()
                .code(this.id)
                .name(this.name)
                .price(this.price)
                .build();
    }
}
