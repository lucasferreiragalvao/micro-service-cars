package com.unifacef.work.groupone.microservicecars.domains;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Car {
    private String code;
    private int year;
    private Classification classification;
    private String color;
    private Brand brand;
    private String model;
    private String name;
    private String board;
    private Double tankSize;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedDate;
}