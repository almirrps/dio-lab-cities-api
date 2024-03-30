package com.github.almirrps.cities.resources;

import com.github.almirrps.cities.entities.City;
import com.github.almirrps.cities.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nearby")
public class NearbyResource {

    @Autowired
    private DistanceService distanceService;

    @GetMapping
    public List<City> nearby(@RequestParam(name = "city_id") final long cityId,
                             @RequestParam(name = "radius") final Double radius) {
        return distanceService.nearby(cityId, radius);
    }

}
