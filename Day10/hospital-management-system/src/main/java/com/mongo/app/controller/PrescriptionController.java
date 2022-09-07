package com.mongo.app.controller;

import com.mongo.app.module.Prescription;
import com.mongo.app.Repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Prescription create(@RequestBody Prescription prescription) {
        prescription = prescriptionRepository.save(prescription);
        return prescription;
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public List<Prescription> view(@RequestParam String name) {
        return prescriptionRepository.findByPatientName(name);
    }



}
