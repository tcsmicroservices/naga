package com.patient.app;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
public class PatientController {






        private Map<String,Patient> patientMap= new HashMap<String,Patient>();

        @GetMapping("/get/patient")
        public Patient getPatient(@RequestParam String name){
            Patient result= patientMap.get(name);
            return result;
        }

        @GetMapping("/get/all")
        public Map<String,Patient> getPatient(){
            return patientMap;
        }

        @PostMapping("save/patient")
        public void SavePatient(@RequestBody Patient patient){
            String name= patient.getName();
            patientMap.put(name,patient);
        }
        @PutMapping("update/patient")
        public Patient updatePatient(@RequestParam String name,@RequestParam int id){
            Patient result= patientMap.get(name);
            result.setId(id);
            patientMap.put(name,result);
            return result;

        }
        @DeleteMapping("remove/patient")
        public void deletePatient(@RequestParam String name){
            patientMap.remove(name);
        }


}
