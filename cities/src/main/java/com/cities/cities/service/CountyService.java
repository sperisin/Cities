package com.cities.cities.service;

import com.cities.cities.dto.CountyDto;

import java.util.List;

public interface CountyService {
    List<CountyDto> getCounties();
    CountyDto getCounty(Integer countyId);
    void updateCounty(CountyDto countyDto);
    void insertCounty(CountyDto countyDto);
    List<CountyDto> searchCounty(String keyword);
    void deleteCounty(Integer countyId);
}
