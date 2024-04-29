package com.tisCities.tisCities.counties;


import com.tisCities.tisCities.cities.City;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class County {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countyId;
    @Column
    private String name;

    public County() {}
    public County(Integer countyId, String name) {
        this.countyId = countyId;
        this.name = name;
    }

    public County(String name) {
        this.name = name;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
