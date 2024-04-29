package com.cities.cities.mapper;

import com.cities.cities.dto.MajorDto;
import com.cities.cities.model.Major;

import java.util.ArrayList;
import java.util.List;

public class MajorMapper {
    public static Major dtoToEntity(MajorDto majorDto) {
        Major major = new Major();
        major.setName(majorDto.getName());
        major.setSurname(majorDto.getSurname());

        return major;
    }

    public static MajorDto entityToDto(Major major) {
        MajorDto dto = new MajorDto();
        dto.setName(major.getName());
        dto.setSurname(major.getSurname());

        return dto;
    }

    public static List<MajorDto> entityListToDtoList(List<Major> majors) {
        List<MajorDto> dtoList = new ArrayList<>();
        for (Major major: majors) {
            dtoList.add(entityToDto(major));
        }

        return dtoList;
    }
}
