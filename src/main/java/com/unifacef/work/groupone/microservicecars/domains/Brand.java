package com.unifacef.work.groupone.microservicecars.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Brand {
    private Boolean imported;
    private String name;
}
