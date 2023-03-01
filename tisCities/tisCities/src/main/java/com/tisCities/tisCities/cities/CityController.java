package com.tisCities.tisCities.cities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/city"})
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/crud")
    public @ResponseBody List<City> getCities() {
        return cityService.getCities();
    }


    @GetMapping(value = "/crud/{cityId}")
    public @ResponseBody City getCity(@PathVariable("cityId") Integer cityId) {
        return cityService.getCity(cityId);
    }

    @DeleteMapping(value = "/crud")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCity(@RequestParam("cityId") Integer cityId) {
        cityService.deleteCity(cityId);
    }

    @PostMapping(value = "/crud")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertCity(@RequestParam String name,
                             @RequestParam Integer postCode,
                             @RequestParam Integer majorId,
                             @RequestParam Integer noOfCitizens,
                             @RequestParam Integer countyId) {
        cityService.insertCity(name, postCode, majorId, noOfCitizens, countyId);
    }

    @PutMapping(value = "/crud/{cityId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCity(@PathVariable("cityId") Integer cityId,
                             @RequestParam String name,
                             @RequestParam Integer postCode,
                             @RequestParam Integer majorId,
                             @RequestParam Integer noOfCitizens,
                             @RequestParam Integer countyId) {
        cityService.updateCity(cityId, name, postCode, majorId, noOfCitizens, countyId);
    }

    @GetMapping(value = "/search")
    public @ResponseBody List<City> searchCity(@RequestParam("searchTerm") String searchTerm) {
        if (searchTerm.equals("") || searchTerm == null) {
            return getCities();
        }
        return cityService.searchCity(searchTerm);
    }
}
