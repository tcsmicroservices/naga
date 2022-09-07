package com.mongo.app.module;

public class Prescription {

    Integer prescriptionId;
    String appointmentId;
    String description;
    String patientName;
    String doctorName;

    public Prescription(Integer prescriptionId, String appointmentId, String description, String patientName, String doctorName) {
        this.prescriptionId = prescriptionId;
        this.appointmentId = appointmentId;
        this.description = description;
        this.patientName = patientName;
        this.doctorName = doctorName;
    }

    public Prescription(){

    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
