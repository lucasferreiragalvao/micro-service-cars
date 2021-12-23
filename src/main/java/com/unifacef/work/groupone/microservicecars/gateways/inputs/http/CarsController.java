package com.unifacef.work.groupone.microservicecars.gateways.inputs.http;

import com.unifacef.work.groupone.microservicecars.gateways.inputs.http.responses.CarResponse;
import com.unifacef.work.groupone.microservicecars.gateways.inputs.http.responses.ListResponse;
import com.unifacef.work.groupone.microservicecars.usecases.FindByCarCode;
import com.unifacef.work.groupone.microservicecars.usecases.FindCars;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "api/v1/cars")
@RequiredArgsConstructor
public class CarsController {

    private final FindCars findCars;
    private final FindByCarCode findByCarCode;

    @GetMapping(path = "/{code}")
    public CarResponse find(@PathVariable final String code){
        return new CarResponse(findByCarCode.execute(code));
    }

    @GetMapping
    public ListResponse<CarResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
                                        @RequestParam(defaultValue = "20") final Integer size){
        Page<CarResponse> carPage = findCars.execute(PageRequest.of(page,size)).map(CarResponse::new);
        return new ListResponse<>(carPage);
    }
}
