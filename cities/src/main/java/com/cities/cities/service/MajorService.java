package com.cities.cities.service;

import com.cities.cities.dto.MajorDto;

import java.util.List;

public interface MajorService {
    List<MajorDto> getMajors();
    MajorDto getMajor(Integer majorId);
    void deleteMajor(Integer majorId);
    void updateMajor(MajorDto majorDto);
    void insertMajor(MajorDto majorDto);
    List<MajorDto> searchMajor(String searchTerm);
}
