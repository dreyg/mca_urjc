package com.example.demo.service;

import javax.annotation.PostConstruct;

import com.example.demo.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleDataService {

	@Autowired
	private CityService cities;
	
	@PostConstruct
	public void init() {

		cities.save(new City("Madrid", "flat"));
		cities.save(new City("Roma", "flat"));
		cities.save(new City("Berlin", "flat"));

		cities.save(new City("Glasgow", "mountain"));
		cities.save(new City("Aspen", "mountain"));
		cities.save(new City("Somiedo", "mountain"));
		cities.save(new City("Cazorla", "mountain"));
	}
	
}
