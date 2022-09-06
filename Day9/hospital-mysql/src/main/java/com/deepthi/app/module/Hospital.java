package com.deepthi.app.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hospital {

    @Id
    @GeneratedValue
    @Column(name="hospId")
    private Integer hospId;

    @Column(name="hospitalName")
    private String hospitalName;

    @Column(name="address")
    private String address;

    public Hospital(){

    }

    public Integer getHospId() {
        return hospId;
    }

    public void setHospId(Integer hospId) {
        this.hospId = hospId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
