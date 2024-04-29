package com.cities.cities.dto;

import com.cities.cities.model.County;
import com.cities.cities.model.Major;

public class CityDto {
    private Integer cityId;
    private String name;
    private Integer postCode;
    private Major major;
    private Integer noOfCitizens;
    private County county;

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
