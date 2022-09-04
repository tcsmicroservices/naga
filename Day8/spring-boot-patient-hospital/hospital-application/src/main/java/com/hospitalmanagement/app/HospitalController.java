package com.hospitalmanagement.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class HospitalController {

    @Autowired
    private RestTemplate restTemplate;

    private HashMap<String,Hospital> hospitalMap = new HashMap<>();
    private HashMap<String, Patient> patientMap = new HashMap<>();

    @GetMapping("/get/hospital")
    public Hospital getHospital(@RequestParam String hospId){
        Hospital hospital = hospitalMap.get(hospId);
        if(hospital == null){
            ResponseEntity<Patient> patient = restTemplate.exchange("http://localhost:8082/patient/get/?patient_id=p1", HttpMethod.GET,null,Patient.class);
            ArrayList<Patient> patientList = new ArrayList<Patient>();
            patientList.add(patient.getBody());
            Hospital test = new Hospital("Capital", "vijayawada", "CodeC", patientList);
            return test;

        }else{
            return hospital;
        }

    }

    @PostMapping("/save/hospital")
    public Hospital saveHospital(@RequestBody Hospital hospital){
        String hospitalId = hospital.getHospId();
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        ResponseEntity<Patient> patient = restTemplate.exchange("http://localhost:8082/patient/save", HttpMethod.POST,null,Patient.class);
        hospital.getPatientList();
        hospitalMap.put(hospitalId,hospital);
        return hospital;
    }

    @PutMapping("/update/hospital")
    public Hospital updateHospital(@RequestParam String hospId,@RequestParam String address){
        Hospital hospital = hospitalMap.get(hospId);
        if(hospital == null){
            ResponseEntity<Patient> patient = restTemplate.exchange("http://localhost:8082/patient/update", HttpMethod.PUT,null,Patient.class);
            ArrayList<Patient> patientList = new ArrayList<Patient>();
            patientList.add(patient.getBody());
            Hospital test = new Hospital("apollo", hospId, address, patientList);
            hospitalMap.put(hospId,test);
            return test;
        }else{
            hospital.setAddress(address);
            hospitalMap.put(hospId,hospital);
            return hospital;
        }

    }
    @DeleteMapping("/delete/hospital")
    public String deleteHospital(@RequestParam String hospId) {
        hospitalMap.remove(hospId);
        HttpHeaders header = new HttpHeaders();
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> res = new HttpEntity<String>(header);
        String result = restTemplate.exchange("http://localhost:8082/patient/delete?patient_id=p1",HttpMethod.DELETE,res,String.class).getBody();
        return "Deleted Hospital "+ result;
    }


}