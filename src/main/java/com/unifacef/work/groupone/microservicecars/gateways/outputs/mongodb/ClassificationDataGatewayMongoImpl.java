package com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb;

import com.unifacef.work.groupone.microservicecars.domains.Classification;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.ClassificationDataGateway;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.documents.ClassificationDocument;
import com.unifacef.work.groupone.microservicecars.gateways.outputs.mongodb.repositories.ClassificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClassificationDataGatewayMongoImpl implements ClassificationDataGateway {

    private final ClassificationRepository classificationRepository;
    @Override
    public Classification save(Classification classification) {
        if(Objects.isNull(classification.getCreatedAt())){
            classification.setCreatedAt(LocalDateTime.now());
        }
        return classificationRepository.save(new ClassificationDocument(classification)).toDomain();
    }

    @Override
    public Optional<Classification> findByName(String name) {
        return classificationRepository.findByName(name).map(ClassificationDocument::toDomain);
    }

    @Override
    public Optional<Classification> findByCode(String code) {
        return classificationRepository.findById(code).map(ClassificationDocument::toDomain);
    }
}
