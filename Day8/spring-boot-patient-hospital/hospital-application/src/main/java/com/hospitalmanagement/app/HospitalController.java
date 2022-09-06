package com.hospitalmanagement.app;


import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

@RestController
public class HospitalController {

    public Map<String,Hospital> hospitalMap = new HashMap<String,Hospital>();
    List<Patient> patients = new ArrayList<>();

    @GetMapping("/get/hospital")
    public Hospital getPatient(@RequestParam String name){
        Hospital result= hospitalMap.get(name);
        if (result == null) {
            Hospital hospital= new Hospital("Hos1","add1","id1", null);
            return hospital;
        }else
            return result;
    }
    @PostMapping("save/hospital")
    public Hospital SavePatient(@RequestBody Hospital hospital){
        String name= hospital.getHospitalName();
        hospitalMap.put(name,hospital);
        return hospital;
    }
    @PutMapping("update/hospital")
    public Hospital updatePatient(@RequestParam String hospitalName,@RequestParam String address){
        Hospital result= hospitalMap.get(hospitalName);
        if (result == null) {
            Hospital hospital= new Hospital(hospitalName,"ABC","123",null);
            hospital.setAddress(address);
            hospitalMap.put(hospitalName,hospital);
            return hospital;
        }else {
            result.setAddress(address);
            hospitalMap.put(hospitalName, result);
            return result;
        }

    }
    @DeleteMapping("remove/hospital")
    public String deletePatient(@RequestParam String name){
        hospitalMap.remove(name);
        return name;
    }


}