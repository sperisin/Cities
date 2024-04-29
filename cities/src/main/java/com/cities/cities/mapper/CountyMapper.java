package com.cities.cities.mapper;

import com.cities.cities.dto.CountyDto;
import com.cities.cities.model.County;

import java.util.ArrayList;
import java.util.List;

public class CountyMapper {

    public static CountyDto entityToDto(County county) {
        CountyDto countyDto = new CountyDto();
        countyDto.setName(county.getName());

        return countyDto;
    }

    public static County dtoToEntity(CountyDto countyDto) {
        County county = new County();
        county.setName(countyDto.getName());

        return county;
    }

    public static List<CountyDto> entityListToDtoList(List<County> counties) {
        List<CountyDto> dtoList = new ArrayList<>();
        for (County county: counties) {
            dtoList.add(entityToDto(county));
        }

        return dtoList;
    }
}
