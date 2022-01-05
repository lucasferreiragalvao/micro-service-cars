package com.unifacef.work.groupone.microservicecars.domains;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Classification {
    private String code;
    private String name;
    private Double price;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedDate;

}
