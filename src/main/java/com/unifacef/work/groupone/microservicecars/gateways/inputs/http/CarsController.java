package com.unifacef.work.groupone.microservicecars.gateways.inputs.http;

import com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests.CreateCarRequest;
import com.unifacef.work.groupone.microservicecars.gateways.inputs.http.requests.UpdateCarRequest;
import com.unifacef.work.groupone.microservicecars.gateways.inputs.http.responses.CarResponse;
import com.unifacef.work.groupone.microservicecars.gateways.inputs.http.responses.ListResponse;
import com.unifacef.work.groupone.microservicecars.usecases.FindByCarCode;
import com.unifacef.work.groupone.microservicecars.usecases.UpdateCar;
import com.unifacef.work.groupone.microservicecars.usecases.CreateCar;
import com.unifacef.work.groupone.microservicecars.usecases.FindCars;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(value = "/api/v1/cars")
@RequiredArgsConstructor
public class CarsController {

    private final CreateCar createCar;
    private final UpdateCar updateCar;
    private final FindCars findCars;
    private final FindByCarCode findByCarCode;


    @PostMapping
    public CarResponse create(@RequestBody @Validated final CreateCarRequest request){
        return new CarResponse(createCar.execute(request.toDomain()));
    }

    @PutMapping(path = "/{code}")
    public CarResponse update(@PathVariable final String code, @RequestBody @Validated final UpdateCarRequest request){
        return new CarResponse(updateCar.execute(request.toDomain(code)));
    }

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
