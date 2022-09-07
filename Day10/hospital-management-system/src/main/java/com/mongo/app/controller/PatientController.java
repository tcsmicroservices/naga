package com.mongo.app.controller;

import com.mongo.app.Repository.AppointmentRepository;
import com.mongo.app.module.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")

    public class PatientController {
        @Autowired
        AppointmentRepository appointmentRepository;

        @RequestMapping(value = "/myappointments", method = RequestMethod.GET)
        public List<Appointment> readAppointments(@RequestParam String patientName) {
            return appointmentRepository.findByPatientName(patientName);
        }

        @RequestMapping(value = "/bookappointment", method = RequestMethod.POST)
        public Appointment book(@RequestBody Appointment appointment) {
            appointment = appointmentRepository.save(appointment);
            return appointment;

        }
}
