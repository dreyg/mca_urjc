package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class CityService {

    @Autowired
    private CityRepository cities;

    public void save(City city){
        cities.save(city);
    }

    public Mono<City> getCity(String id) {
        return cities.findById(id).delayElement(Duration.ofMillis(3000))
                .switchIfEmpty(
                        Mono.error(new ResponseStatusException(
                                HttpStatus.NOT_FOUND, "City with id "+id+" not found")));
    }

}
