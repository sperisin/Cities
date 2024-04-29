package com.cities.cities.service;

import com.cities.cities.dto.CityDto;

import java.util.List;

public interface CityService {
    List<CityDto> getCities();
    CityDto getCity(Integer cityId);
    void deleteCity(Integer cityId);
    void insertCity(CityDto dto);
    List<CityDto> searchCity(String searchTerm);
    void updateCity(CityDto dto);
}
