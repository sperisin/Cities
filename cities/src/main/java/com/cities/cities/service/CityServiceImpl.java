package com.cities.cities.service;

import com.cities.cities.dto.CityDto;
import com.cities.cities.mapper.CityMapper;
import com.cities.cities.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<CityDto> getCities() {
        return CityMapper.entityListToDtoList(cityRepository.findAll());
    }

    @Override
    public CityDto getCity(Integer cityId) {
        return CityMapper.entityToDto(cityRepository.findById(cityId).get());
    }

    @Override
    public void deleteCity(Integer cityId) {
        cityRepository.deleteById(cityId);
    }

    @Override
    public void updateCity(CityDto dto) {
        cityRepository.save(CityMapper.dtoToEntity(dto));
    }

    @Override
    public void insertCity(CityDto dto) {
        cityRepository.save(CityMapper.dtoToEntity(dto));
    }

    @Override
    public List<CityDto> searchCity(String searchTerm) {
        if (searchTerm != null && (!searchTerm.isEmpty())) {
            return CityMapper.entityListToDtoList(cityRepository.findBySearchStringName(searchTerm.toLowerCase(Locale.ROOT)));
        }
        return getCities();
    }
}
