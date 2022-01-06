package com.unifacef.work.groupone.microservicecars.gateways.inputs.http;

import com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests.CreateClassificationRequest;
import com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests.PathClassificationRequest;
import com.unifacef.work.groupone.microservicecars.gateways.inputs.http.responses.ClassificationResponse;
import com.unifacef.work.groupone.microservicecars.gateways.inputs.http.responses.ListResponse;
import com.unifacef.work.groupone.microservicecars.usecases.CreateClassification;
import com.unifacef.work.groupone.microservicecars.usecases.FindByClassificationCode;
import com.unifacef.work.groupone.microservicecars.usecases.FindClassifications;
import com.unifacef.work.groupone.microservicecars.usecases.PatchClassification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/api/v1/classification")
@RequiredArgsConstructor
public class ClassificationController {

    private final CreateClassification createClassification;
    private final PatchClassification patchClassification;
    private final FindClassifications findClassifications;
    private final FindByClassificationCode findByClassificationCode;

    @PostMapping
    public ClassificationResponse create(@RequestBody @Validated final CreateClassificationRequest request){
        return new ClassificationResponse(createClassification.execute(request.toDomain()));
    }

    @PatchMapping(path = "/{code}")
    public ClassificationResponse patch(@PathVariable final String code, @RequestBody @Validated final PathClassificationRequest request){
        return new ClassificationResponse(patchClassification.execute(request.toDomain(code)));
    }

    @GetMapping
    public ListResponse<ClassificationResponse> list(@RequestParam(defaultValue = "0") final Integer page,
                                                    @RequestParam(defaultValue = "20") final Integer size){
        Page<ClassificationResponse> carPage = findClassifications.execute(PageRequest.of(page,size)).map(ClassificationResponse::new);
        return new ListResponse<>(carPage);
    }

    @GetMapping(path = "/{code}")
    public ClassificationResponse find(@PathVariable final String code){
        return new ClassificationResponse(findByClassificationCode.execute(code));
    }
}
