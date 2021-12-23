package com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.documents;

import com.unifacef.work.groupone.microservicecars.domains.Brand;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BrandDocument {
    private Boolean imported;
    private String name;

    public BrandDocument(final Brand brand){
        this.imported = brand.getImported();
        this.name = brand.getName();
    }

    public Brand toDomain(){
        return Brand.builder()
                .imported(this.imported)
                .name(this.name)
                .build();
    }
}
