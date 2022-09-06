package com.deepthi.app.repository;

import com.deepthi.app.module.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {

}
