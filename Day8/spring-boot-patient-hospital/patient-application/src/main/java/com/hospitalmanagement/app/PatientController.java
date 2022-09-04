package com.hospitalmanagement.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class PatientController {
    @Autowired
    private RestTemplate restTemplate;


    private HashMap<String, Patient> patientHashMap = new HashMap<>();

    @GetMapping("/patient/get")
    public Patient getPatient(@RequestParam String patient_id) {
        Patient patient = patientHashMap.get(patient_id);
        if (patient == null) {
            Patient test = new Patient("abcd", "p123", "Asthma", "apollo");
            return test;
        } else {
            return patient;
        }
    }

    @DeleteMapping("/patient/delete")
    public String deletePatient(@RequestParam String patientId) {
        patientHashMap.remove(patientId);
        return "Deleted";

    }

    @PostMapping("/patient/save")
    public Patient savePatient(@RequestBody Patient patient) {
        String patientId = patient.getPatientId();
        patientHashMap.put(patientId, patient);
        return patient;
    }

    @PutMapping("/patient/update")
    public Patient updatePatient(@RequestParam String patient_id, @RequestParam String disease) {
        Patient patient = patientHashMap.get(patient_id);
        if (patient == null) {
            Patient test = new Patient("abcd", "p123", "Asthma", "apollo");
            patientHashMap.put(patient_id, test);
            return test;
        } else {
            patient.setDisease(disease);
            patientHashMap.put(patient_id, patient);
            return patient;
        }
    }
}