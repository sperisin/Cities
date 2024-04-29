package com.cities.cities.service;

import com.cities.cities.dto.CountyDto;
import com.cities.cities.mapper.CountyMapper;
import com.cities.cities.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyServiceImpl implements CountyService {

    private final CountyRepository countyRepository;

    @Autowired
    public CountyServiceImpl(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    @Override
    public List<CountyDto> getCounties() {
        return CountyMapper.entityListToDtoList(countyRepository.findAll());
    }

    @Override
    public CountyDto getCounty(Integer countyId) {
        return CountyMapper.entityToDto(countyRepository.findById(countyId).get());
    }

    @Override
    public void deleteCounty(Integer countyId) {
        countyRepository.deleteById(countyId);
    }

    @Override
    public void updateCounty(CountyDto countyDto) {
        countyRepository.save(CountyMapper.dtoToEntity(countyDto));
    }

    @Override
    public void insertCounty(CountyDto countyDto) {
        countyRepository.save(CountyMapper.dtoToEntity(countyDto));
    }

    @Override
    public List<CountyDto> searchCounty(String keyword) {
        if (keyword != null && (!keyword.isEmpty())) {
            return CountyMapper.entityListToDtoList(countyRepository.findByNameIgnoreCaseContaining(keyword));
        }
        return getCounties();
    }
}
