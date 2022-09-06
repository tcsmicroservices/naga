package com.deepthi.app.controller;

import com.deepthi.app.module.Patient;
import com.deepthi.app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;
    @GetMapping(value = "/view")
    public @ResponseBody
    Iterable<Patient> getAll() {
        return patientRepository.findAll();
    }

    @PostMapping(value = "/create")
    public @ResponseBody
    String store(@RequestBody final Patient patient) {
        patientRepository.save(patient);
        return "saved";
    }
    @PutMapping(value = "/update")
    @ResponseBody public Patient updatePatient(@RequestParam Integer id,@RequestParam String disease){
        Patient patient = patientRepository.findById(id).get();
        patient.setDisease(disease);
        patientRepository.save(patient);
        return patient;
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody public String deletePatientById(@RequestParam Integer id){
        patientRepository.deleteById(id);
        return "Deleted";
    }

}
