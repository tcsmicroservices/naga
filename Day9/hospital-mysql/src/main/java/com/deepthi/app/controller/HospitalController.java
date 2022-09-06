package com.deepthi.app.controller;

import com.deepthi.app.module.Hospital;
import com.deepthi.app.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/hospital")
public class HospitalController {

    @Autowired
    HospitalRepository hospitalRepository;

    @GetMapping(value="/view")
    public @ResponseBody
    Iterable<Hospital> getAll() {
        return hospitalRepository.findAll();
    }

    @PostMapping(value = "/create")
    public @ResponseBody
    String store(@RequestBody final Hospital hospital) {
        hospitalRepository.save(hospital);
        return "saved";
    }
    @PutMapping(value = "/update")
    @ResponseBody public Hospital updateAddress(@RequestParam Integer id,@RequestParam String address){
        Hospital hospital = hospitalRepository.findById(id).get();
        hospital.setAddress(address);
        hospitalRepository.save(hospital);
        return hospital;
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody public String deleteHospitalById(@RequestParam Integer id){
        hospitalRepository.deleteById(id);
        return "Deleted";
    }



}
