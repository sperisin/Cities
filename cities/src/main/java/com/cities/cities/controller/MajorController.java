package com.cities.cities.controller;

import com.cities.cities.dto.MajorDto;
import com.cities.cities.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping({"/api/major"})
public class MajorController {

    private final MajorService majorService;

    @Autowired
    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    @GetMapping(value = "/crud")
    public @ResponseBody List<MajorDto> getMajors() {
        return majorService.getMajors();
    }


    @GetMapping(value = "/crud/{majorId}")
    public @ResponseBody MajorDto getMajor(@PathVariable("majorId") Integer majorId) {
        return majorService.getMajor(majorId);
    }

    @DeleteMapping(value = "/crud")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMajor(@RequestParam("majorId") Integer majorId) {
        majorService.deleteMajor(majorId);
    }

    @PostMapping(value = "/crud")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertMajor(@RequestBody MajorDto majorDto) {
        majorService.insertMajor(majorDto);
    }

    @PutMapping(value = "/crud")
    @ResponseStatus(HttpStatus.OK)
    public void updateMajor(@RequestBody MajorDto majorDto) {
        majorService.updateMajor(majorDto);
    }

    @GetMapping(value = "/search")
    public @ResponseBody List<MajorDto> searchMajor(
            @RequestParam("searchTerm") String searchTerm) {
        if (searchTerm.equals("") || searchTerm == null)  {
            return getMajors();
        }
        return majorService.searchMajor(searchTerm);
    }
}
