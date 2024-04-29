package com.cities.cities.model;

import jakarta.persistence.*;

@Entity
@Table
public class City {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cityId;
    @Column
    private String name;
    @Column
    private Integer postCode;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "majorId", nullable = true)
    private Major major;
    @Column
    private Integer noOfCitizens;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "countyId", nullable = true)
    private County county;

    public City() {}
    public City(Integer cityId, String name, Integer postCode, Major major, Integer noOfCitizens, County county) {
        this.cityId = cityId;
        this.name = name;
        this.postCode = postCode;
        this.major = major;
        this.noOfCitizens = noOfCitizens;
        this.county = county;
    }

    public City(String name, Integer postCode, Major major, Integer noOfCitizens, County county) {
        this.name = name;
        this.postCode = postCode;
        this.major = major;
        this.noOfCitizens = noOfCitizens;
        this.county = county;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Integer getNoOfCitizens() {
        return noOfCitizens;
    }

    public void setNoOfCitizens(Integer noOfCitizens) {
        this.noOfCitizens = noOfCitizens;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }
}
