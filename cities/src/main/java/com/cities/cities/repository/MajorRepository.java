package com.cities.cities.repository;

import com.cities.cities.model.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorRepository extends JpaRepository<Major, Integer> {
    @Query("select m from Major m where lower(name) like %:searchString% or lower(surname) like %:searchString%")

    List<Major> findBySearchString(@Param("searchString") String searchString);
}
