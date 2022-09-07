package com.mongo.app.Repository;

import com.mongo.app.module.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment,Integer> {
    public List<Appointment> findByDoctorName(String doctorName);
    public List<Appointment> findByPatientName(String patientName);
    public Appointment save(Appointment appointment);
}
