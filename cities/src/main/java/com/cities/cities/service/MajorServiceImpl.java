package com.cities.cities.service;

import com.cities.cities.dto.MajorDto;
import com.cities.cities.mapper.MajorMapper;
import com.cities.cities.repository.MajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class MajorServiceImpl implements MajorService {

    private final MajorRepository majorRepository;

    @Autowired
    public MajorServiceImpl(MajorRepository majorRepository) {
        this.majorRepository = majorRepository;
    }

    @Override
    public List<MajorDto> getMajors() {
        return MajorMapper.entityListToDtoList(majorRepository.findAll());
    }

    @Override
    public MajorDto getMajor(Integer majorId) {
        return MajorMapper.entityToDto(majorRepository.findById(majorId).get());
    }

    @Override
    public void deleteMajor(Integer majorId) {
        majorRepository.deleteById(majorId);
    }

    @Override
    public void updateMajor(MajorDto majorDto) {
        majorRepository.save(MajorMapper.dtoToEntity(majorDto));
    }

    @Override
    public void insertMajor(MajorDto majorDto) {
        majorRepository.save(MajorMapper.dtoToEntity(majorDto));
    }

    @Override
    public List<MajorDto> searchMajor(String searchTerm) {
        if (searchTerm != null && (!searchTerm.isEmpty())) {
            return MajorMapper.entityListToDtoList(majorRepository.findBySearchString(searchTerm.toLowerCase(Locale.ROOT)));
        }
        return getMajors();
    }
}
