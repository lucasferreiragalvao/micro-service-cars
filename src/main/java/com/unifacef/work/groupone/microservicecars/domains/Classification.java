package com.unifacef.work.groupone.microservicecars.domains;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Classification {
    SUV("suv"),
    COMPACTO("compacto"),
    LUXO("luxo");

    private String description;

}
