package com.tisCities.tisCities.cities;

import com.tisCities.tisCities.counties.County;
import com.tisCities.tisCities.counties.CountyRepository;
import com.tisCities.tisCities.counties.CountyService;
import com.tisCities.tisCities.majors.Major;
import com.tisCities.tisCities.majors.MajorRepository;
import com.tisCities.tisCities.majors.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final CountyRepository countyRepository;
    private final MajorRepository majorRepository;

    @Autowired
    public CityService(CityRepository cityRepository,
                       MajorRepository majorRepository,
                       CountyRepository countyRepository) {
        this.cityRepository = cityRepository;
        this.countyRepository = countyRepository;
        this.majorRepository = majorRepository;
    }

    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public City getCity(Integer cityId) {
        return cityRepository.findById(cityId).get();
    }

    public void deleteCity(Integer cityId) {
        City city = this.getCity(cityId);
        cityRepository.delete(city);
    }

    public void updateCity(Integer cityId,
                           String name,
                           Integer postCode,
                           Integer majorId,
                           Integer noOfCitizens,
                           Integer countyId) {
        MajorService majorService = new MajorService(majorRepository);
        CountyService countyService = new CountyService(countyRepository);

        City cityToUpdate = getCity(cityId);
        cityToUpdate.setName(name);
        cityToUpdate.setPostCode(postCode);

        Major major = majorService.getMajor(majorId);
        cityToUpdate.setMajor(major);

        cityToUpdate.setNoOfCitizens(noOfCitizens);

        County county = countyService.getCounty(countyId);
        cityToUpdate.setCounty(county);

        cityRepository.save(cityToUpdate);
    }

    public void insertCity(String name,
                           Integer postCode,
                           Integer majorId,
                           Integer noOfCitizens,
                           Integer countyId) {

        MajorService majorService = new MajorService(majorRepository);
        CountyService countyService = new CountyService(countyRepository);
        Major major = majorService.getMajor(majorId);
        County county = countyService.getCounty(countyId);

        City cityToInsert = new City(name, postCode, major, noOfCitizens, county);
        cityRepository.save(cityToInsert);
    }

    public List<City> searchCity(String searchTerm) {
        if (searchTerm != null && (!searchTerm.equals(""))) {
            return cityRepository.findBySearchStringName(searchTerm.toLowerCase(Locale.ROOT));
        }
        return getCities();
    }
}
