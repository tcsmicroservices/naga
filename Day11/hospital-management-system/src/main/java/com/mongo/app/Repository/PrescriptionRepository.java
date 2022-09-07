package com.mongo.app.Repository;

import com.mongo.app.module.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends MongoRepository<Prescription,Integer> {
    public List<Prescription> findByPatientName(String patientName);
    public Prescription save(Prescription prescription);
}
