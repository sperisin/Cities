package com.cities.cities.repository;

import com.cities.cities.model.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountyRepository extends JpaRepository<County, Integer> {
    @Query("select c from County c where lower(c.name) like %:searchString%")
    List<County> findByNameIgnoreCaseContaining(String searchString);
}
