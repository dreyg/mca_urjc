package es.codeurjc.mastercloudapps.planner.controller;

import es.codeurjc.mastercloudapps.planner.model.City;
import es.codeurjc.mastercloudapps.planner.model.CityDTO;
import es.codeurjc.mastercloudapps.planner.service.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topographicdetails")
public class TopoController {

    @Autowired
    private TopoService topoService;

    @GetMapping("/{city}")
    public CityDTO getCity(@PathVariable String city) {
        return toCityDTO(topoService.getCity(city));
    }

    private CityDTO toCityDTO(City city) {
        return new CityDTO(city.getId(), city.getLandscape());
    }

}
