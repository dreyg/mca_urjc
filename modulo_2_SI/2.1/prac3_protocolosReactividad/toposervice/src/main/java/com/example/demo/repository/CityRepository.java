package com.example.demo.repository;

import com.example.demo.model.City;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CityRepository extends ReactiveMongoRepository<City, String> {

}
