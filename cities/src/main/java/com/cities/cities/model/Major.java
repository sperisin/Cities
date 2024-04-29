package com.cities.cities.model;

import jakarta.persistence.*;

@Entity
@Table
public class Major {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer majorId;
    @Column
    private String name;
    @Column
    private String surname;

    public Major() {}
    public Major(Integer majorId, String name, String surname) {
        this.majorId = majorId;
        this.name = name;
        this.surname = surname;
    }

    public Major(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
