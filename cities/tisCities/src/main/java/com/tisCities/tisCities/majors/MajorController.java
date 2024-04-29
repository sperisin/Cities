package com.tisCities.tisCities.majors;

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
    public @ResponseBody List<Major> getMajors() {
        return majorService.getMajors();
    }


    @GetMapping(value = "/crud/{majorId}")
    public @ResponseBody Major getMajor(@PathVariable("majorId") Integer majorId) {
        return majorService.getMajor(majorId);
    }

    @DeleteMapping(value = "/crud")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMajor(@RequestParam("majorId") Integer majorId) {
        majorService.deleteMajor(majorId);
    }

    @PostMapping(value = "/crud")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertMajor(@RequestParam("majorName") String majorName,
                             @RequestParam("majorSurname") String majorSurname) {
        majorService.insertMajor(majorName, majorSurname);
    }

    @PutMapping(value = "/crud/{majorId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateMajor(@PathVariable("majorId") Integer majorId,
                            @RequestParam("majorName") String majorName,
                            @RequestParam("majorSurname") String majorSurname) {
        majorService.updateMajor(majorId, majorName, majorSurname);
    }

    @GetMapping(value = "/search")
    public @ResponseBody List<Major> searchMajor(
            @RequestParam("searchTerm") String searchTerm) {
        if (searchTerm.equals("") || searchTerm == null)  {
            return getMajors();
        }
        return majorService.searchMajor(searchTerm);
    }
}
