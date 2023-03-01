package com.tisCities.tisCities.counties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping({"/api/county"})
public class CountyController {

    private final CountyService countyService;

    @Autowired
    public CountyController(CountyService countyService) {
        this.countyService = countyService;
    }

    @GetMapping(value = "/crud")
    public @ResponseBody List<County> getCounties() {
        return countyService.getCounties();
    }


    @GetMapping(value = "/crud/{countyId}")
    public @ResponseBody County getCounty(@PathVariable("countyId") Integer countyId) {
        return countyService.getCounty(countyId);
    }

    @DeleteMapping(value = "/crud")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCounty(@RequestParam("countyId") Integer countyId) {
        countyService.deleteCounty(countyId);
    }

    @PostMapping(value = "/crud")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertCounty(@RequestBody String countyName) {
        countyService.insertCounty(countyName);
    }

    @PutMapping(value = "/crud/{countyId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCounty(@PathVariable("countyId") Integer countyId,
                             @RequestBody String countyName) {
        countyService.updateCounty(countyId, countyName);
    }

    @GetMapping(value = "/search")
    public @ResponseBody List<County> searchCounty(@RequestParam("countyName") String countyName) {
        if (countyName.equals("") || countyName == null) {
            return getCounties();
        }
        return countyService.searchCounty(countyName);
    }
}
