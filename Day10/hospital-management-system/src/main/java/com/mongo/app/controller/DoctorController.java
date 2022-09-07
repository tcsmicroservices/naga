package com.mongo.app.controller;


import com.mongo.app.Repository.AppointmentRepository;
import com.mongo.app.module.Appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    AppointmentRepository appointmentRepository;

    @RequestMapping(value="/appointments",method= RequestMethod.GET)
    public List<Appointment> readAppointments(@RequestParam String doctorName){
        return appointmentRepository.findByDoctorName(doctorName);
    }


}
