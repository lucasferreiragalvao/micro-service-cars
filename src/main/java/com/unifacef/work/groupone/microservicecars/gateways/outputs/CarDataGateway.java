package com.unifacef.work.groupone.microservicecars.gateways.outputs;

import com.unifacef.work.groupone.microservicecars.domains.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarDataGateway {
    Page<Car> findByPage(Pageable pageable);
}
