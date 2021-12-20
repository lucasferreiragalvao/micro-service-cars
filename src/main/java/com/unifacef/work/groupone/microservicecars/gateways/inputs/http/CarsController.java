package com.unifacef.work.groupone.microservicecars.gateways.inputs.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/cars")
public class CarsController {

    @GetMapping
    public String listCars(){ return "Cars"; }
}
