package com.cities.cities.mapper;

import com.cities.cities.dto.CityDto;
import com.cities.cities.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityMapper {

    public static City dtoToEntity(CityDto cityDto) {
        City city = new City();
        city.setMajor(cityDto.getMajor());
        city.setCounty(cityDto.getCounty());
        city.setName(cityDto.getName());
        city.setPostCode(cityDto.getPostCode());
        city.setNoOfCitizens(cityDto.getNoOfCitizens());

        return city;
    }

    public static CityDto entityToDto(City city) {
        CityDto dto = new CityDto();
        dto.setCounty(city.getCounty());
        dto.setMajor(city.getMajor());
        dto.setName(city.getName());
        dto.setPostCode(city.getPostCode());
        dto.setNoOfCitizens(city.getNoOfCitizens());

        return dto;
    }

    public static List<CityDto> entityListToDtoList(List<City> cities) {
        List<CityDto> dtoList = new ArrayList<>();
        for (City city: cities) {
            dtoList.add(entityToDto(city));
        }

        return dtoList;
    }
}
