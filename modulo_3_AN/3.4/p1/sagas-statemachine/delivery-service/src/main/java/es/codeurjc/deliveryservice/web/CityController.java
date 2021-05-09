package es.codeurjc.deliveryservice.web;

import es.codeurjc.deliveryservice.dto.*;
import es.codeurjc.deliveryservice.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/")
public class CityController {

	private CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}

    @GetMapping("city/{cityId}")
    public ResponseEntity<CityResponse> getCity(@PathVariable(value = "cityId") UUID cityId) {
        return new ResponseEntity<>(cityService.getCity(cityId), HttpStatus.OK);
    }	
    
	@PostMapping("city")
	public ResponseEntity<CreateCityResponse> createCity(@RequestBody CreateCityRequest createCityRequest) {
		return new ResponseEntity<>(cityService.createCity(createCityRequest),HttpStatus.CREATED);
	}
	
}
