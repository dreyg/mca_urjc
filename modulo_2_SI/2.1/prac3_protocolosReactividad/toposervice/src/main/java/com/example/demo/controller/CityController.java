package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/topographicdetails")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/{id}")
    public Mono<City> getPost(@PathVariable String id) {

        return cityService.getCity(id).map(this::toCity);
    }

    private City toCity(City cityDTO) {
        return new City(cityDTO.getId(), cityDTO.getLandscape());
    }

}
