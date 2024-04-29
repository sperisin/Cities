package com.cities.cities.controller;

import com.cities.cities.dto.CityDto;
import com.cities.cities.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/crud")
    public @ResponseBody List<CityDto> getCities() {
        return cityService.getCities();
    }


    @GetMapping(value = "/crud/{cityId}")
    public @ResponseBody CityDto getCity(@PathVariable("cityId") Integer cityId) {
        return cityService.getCity(cityId);
    }

    @DeleteMapping(value = "/crud")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCity(@RequestParam("cityId") Integer cityId) {
        cityService.deleteCity(cityId);
    }

    @PostMapping(value = "/crud")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertCity(@RequestBody CityDto cityDto) {
        cityService.insertCity(cityDto);
    }

    @PutMapping(value = "/crud")
    @ResponseStatus(HttpStatus.OK)
    public void updateCity(@RequestBody CityDto cityDto) {
        cityService.updateCity(cityDto);
    }

    @GetMapping(value = "/search")
    public @ResponseBody List<CityDto> searchCity(@RequestParam("searchTerm") String searchTerm) {
        if (searchTerm.equals("") || searchTerm == null) {
            return getCities();
        }
        return cityService.searchCity(searchTerm);
    }
}
