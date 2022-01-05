package com.unifacef.work.groupone.microservicecars.gateways.outputs;

import com.unifacef.work.groupone.microservicecars.domains.Classification;

import java.util.Optional;

public interface ClassificationDataGateway {
    Classification save(Classification classification);

    Optional<Classification> findByName(String name);

    Optional<Classification> findByCode(String code);
}
