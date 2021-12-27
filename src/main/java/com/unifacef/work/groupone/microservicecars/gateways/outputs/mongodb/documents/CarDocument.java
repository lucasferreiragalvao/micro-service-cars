package com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.documents;

import com.unifacef.work.groupone.microservicecars.domains.Brand;
import com.unifacef.work.groupone.microservicecars.domains.Car;
import com.unifacef.work.groupone.microservicecars.domains.Classification;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document("cars")
public class CarDocument {
    @Id
    private String id;
    private int year;
    private String color;
    private Classification classification;
    private BrandDocument brand;
    private String model;
    private String name;
    private String board;
    private Double tankSize;
    private Boolean isActive;
    private String note;
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    public CarDocument(final Car car){
        this.id = car.getCode();
        this.year = car.getYear();
        this.color = car.getColor();
        this.classification = Classification.valueOf(car.getClassification().toString());
        this.brand = new BrandDocument(car.getBrand());
        this.model = car.getModel();
        this.name = car.getName();
        this.board = car.getBoard();
        this.tankSize = car.getTankSize();
        this.isActive = car.getIsActive();
        this.note = car.getNote();
        this.createdDate = car.getCreatedAt();
        this.lastModifiedDate = car.getLastModifiedDate();
    }

    public Car toDomain(){
        return Car.builder()
                .code(this.id)
                .year(this.year)
                .color(this.color)
                .classification(this.classification)
                .brand(Brand.builder().imported(this.brand.getImported()).name(this.brand.getName()).build())
                .model(this.model)
                .name(this.name)
                .board(this.board)
                .tankSize(this.tankSize)
                .isActive(this.isActive)
                .note(this.note)
                .createdAt(this.createdDate)
                .lastModifiedDate(this.lastModifiedDate)
                .build();
    }
}
