package com.hospitalmanagement.app;

public class Patient {
    String patientName;
    String patientId;


    String disease;

    String hospitalName;

    public Patient(String patientName, String patientId, String disease, String hospitalName) {
        this.patientName = patientName;
        this.patientId = patientId;
        this.disease=disease;
        this.hospitalName=hospitalName;
    }

    public Patient() {
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }


    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }



    public void setDisease(String disease) {
        this.disease = disease;
    }


    public String getPatientName() {
        return patientName;
    }

    public String getPatientId() {
        return patientId;
    }


    public String getDisease() {
        return disease;
    }

}
