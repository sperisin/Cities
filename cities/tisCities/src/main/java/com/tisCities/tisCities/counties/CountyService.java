package com.tisCities.tisCities.counties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class CountyService {

    private final CountyRepository countyRepository;

    @Autowired
    public CountyService(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    public List<County> getCounties() {
        return countyRepository.findAll();
    }

    public County getCounty(Integer countyId) {
        return countyRepository.findById(countyId).get();
    }

    public void deleteCounty(Integer countyId) {
        County county = this.getCounty(countyId);
        countyRepository.delete(county);
    }

    public void updateCounty(Integer countyId, String countyName) {
        County countyToUpdate = countyRepository.findById(countyId).get();
        countyToUpdate.setName(countyName);
        countyRepository.save(countyToUpdate);
    }

    public void insertCounty(String countyName) {
        County county = new County(countyName);
        countyRepository.save(county);
    }

    public List<County> searchCounty(String keyword) {
        if (keyword != null && (!keyword.equals(""))) {
            return countyRepository.findByNameIgnoreCaseContaining(keyword);
        }
        return getCounties();
    }
}
