package com.cities.cities.controller;

import com.cities.cities.dto.CountyDto;
import com.cities.cities.service.CountyService;
import com.cities.cities.service.CountyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/county")
public class CountyController {

    private final CountyService countyService;

    @Autowired
    public CountyController(CountyService countyService) {
        this.countyService = countyService;
    }

    @GetMapping(value = "/crud")
    public @ResponseBody List<CountyDto> getCounties() {
        return countyService.getCounties();
    }


    @GetMapping(value = "/crud/{countyId}")
    public @ResponseBody CountyDto getCounty(@PathVariable("countyId") Integer countyId) {
        return countyService.getCounty(countyId);
    }

    @DeleteMapping(value = "/crud")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCounty(@RequestParam("countyId") Integer countyId) {
        countyService.deleteCounty(countyId);
    }

    @PostMapping(value = "/crud")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertCounty(@RequestBody CountyDto countyDto) {
        countyService.insertCounty(countyDto);
    }

    @PutMapping(value = "/crud")
    @ResponseStatus(HttpStatus.OK)
    public void updateCounty(@RequestBody CountyDto countyDto) {
        countyService.updateCounty(countyDto);
    }

    @GetMapping(value = "/search")
    public @ResponseBody List<CountyDto> searchCounty(@RequestParam("countyName") String countyName) {
        if (countyName.equals("") || countyName == null) {
            return getCounties();
        }
        return countyService.searchCounty(countyName);
    }
}
