package com.unifacef.work.groupone.microservicecars.gateways.inputs.http;

import com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests.CreateClassificationRequest;
import com.unifacef.work.groupone.microservicecars.gateways.inputs.http.responses.ClassificationResponse;
import com.unifacef.work.groupone.microservicecars.usecases.CreateClassification;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/classification")
@RequiredArgsConstructor
public class ClassificationController {

    private final CreateClassification createClassification;

    @PostMapping
    public ClassificationResponse create(@RequestBody @Validated final CreateClassificationRequest request){
        return new ClassificationResponse(createClassification.execute(request.toDomain()));
    }
}
