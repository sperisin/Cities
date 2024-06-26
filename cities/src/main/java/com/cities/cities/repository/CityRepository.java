package com.cities.cities.repository;

import com.cities.cities.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    @Query("select c from City c where lower(c.name) like %:searchString%")
    List<City> findBySearchStringName(@Param("searchString") String searchString);
}
