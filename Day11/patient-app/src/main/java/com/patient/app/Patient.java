package com.patient.app;

import org.springframework.stereotype.Component;

@Component
public class Patient {
    String name;
    int id;
    String cause;
    String hospital;

    public Patient() {
    }

    public Patient(String name, int id, String cause, String hospital) {
        this.name = name;
        this.id = id;
        this.cause = cause;
        this.hospital = hospital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
