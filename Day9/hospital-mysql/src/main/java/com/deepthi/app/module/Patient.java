package com.deepthi.app.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {

    @Id
    @GeneratedValue
    @Column(name="patid")
    private Integer patid;

    @Column(name="patName")
    private String patName;

    @Column(name="disease")
    private String  disease;

    @Column(name="hospital")
    private String hospitalname;

    public Patient(){

    }

    public Integer getPatid() {
        return patid;
    }

    public void setPatid(Integer patid) {
        this.patid = patid;
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }
}
