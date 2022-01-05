package com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.documents;

import com.unifacef.work.groupone.microservicecars.domains.Brand;
import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.domains.Classification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document("classifications")
public class ClassificationDocument {
    @Id
    private String id;
    private String name;
    private Double price;
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public ClassificationDocument(final Classification classification){
       this.id = classification.getCode();
       this.name = classification.getName();
       this.price = classification.getPrice();
       this.createdDate = classification.getCreatedAt();
       this.lastModifiedDate = classification.getLastModifiedDate();
    }

    public Classification toDomain(){
        return Classification.builder()
                .code(this.id)
                .name(this.name)
                .price(this.price)
                .createdAt(this.createdDate)
                .lastModifiedDate(this.lastModifiedDate)
                .build();
    }
}
