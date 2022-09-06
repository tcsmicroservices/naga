package com.hospitalmanagement.app;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Hospital {
    String hospitalName;
    String address;
    String hospId;

    List<Patient> patients;

    public Hospital() {
    }
    public Hospital(String hospitalName, String address, String hospId, List<Patient> patients)
    {
        this.hospitalName=hospitalName;
        this.address=address;
        this.hospId =hospId;
        this.patients=patients;
    }

    public List<Patient> getPatientList() {
        return patients;
    }

    public void setPatientList(List<Patient> patients) {
        this.patients = patients;
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

    public String getHospId() {
        return hospId;
    }

    public void setHospId(String hospId) {
        this.hospId = hospId;
    }


}