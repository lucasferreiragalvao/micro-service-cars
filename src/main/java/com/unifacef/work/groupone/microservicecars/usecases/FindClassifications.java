package com.unifacef.work.groupone.microservicecars.usecases;

import com.unifacef.work.groupone.microservicecars.domains.Classification;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.ClassificationDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindClassifications {

    private final ClassificationDataGateway classificationDataGateway;

    public Page<Classification> execute(final Pageable pageable){
        log.info("Find Classifications. Page: {}, Size: {}", pageable.getPageNumber(),pageable.getPageSize());
        return classificationDataGateway.findByPage(pageable);
    }
}
