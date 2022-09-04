package com.hospitalmanagement.app;


import java.util.ArrayList;

@Component
public class Hospital {
    String hospitalName;
    String address;
    String hospId;
    ArrayList<Patient> patientList= new ArrayList<>();

    public Hospital() {
    }
    public Hospital(String hospitalName, String address, String hospId, ArrayList<Patient> patientList)
    {
        this.hospitalName=hospitalName;
        this.address=address;
        this.hospId =hospId;
        this.patientList=patientList;
    }

    public ArrayList<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<Patient> patientList) {
        this.patientList = patientList;
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