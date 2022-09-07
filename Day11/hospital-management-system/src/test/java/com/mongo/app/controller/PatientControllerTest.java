package com.mongo.app.controller;


import com.mongo.app.Repository.AppointmentRepository;
import com.mongo.app.Repository.PrescriptionRepository;
import com.mongo.app.module.Appointment;
import com.mongo.app.module.Prescription;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {

    @InjectMocks
    private PatientController patientController;
    @Mock
    private AppointmentRepository appointmentRepository;
    private PrescriptionRepository prescriptionRepository;

    @Test
    public void viewAppointmentsTest(){
        List<Appointment> appointments= new ArrayList();
        Appointment mockAppointment = mock(Appointment.class);
        Appointment dummyAppointment = new Appointment(1,"pat1","doc1","7 Sept", new Prescription(1,1, "prescription1","pat1","doc1") );
        appointments.add(dummyAppointment);
        when(appointmentRepository.findByPatientName(anyString())).thenReturn(appointments);
        List<Appointment> result = appointmentRepository.findByPatientName("pat1");
        Assert.assertEquals(result.get(0).getAppointmentId(), dummyAppointment.getAppointmentId());
        Assert.assertEquals(result.get(0).getPatientName(), dummyAppointment.getPatientName());
        Assert.assertEquals(result.get(0).getDate(), dummyAppointment.getDate());

    }

    @Test
    public void bookAppointmentsTest(){
        Appointment mockAppointment = mock(Appointment.class);
        Appointment appointment = new Appointment(1,"pat1","doc1","7 Sept", new Prescription(1,1, "prescription1","pat1","doc1") );

        when(appointmentRepository.save(any(Appointment.class))).thenReturn(appointment);
        Appointment result = appointmentRepository.save(appointment);
        Assert.assertEquals(result.getAppointmentId(), appointment.getAppointmentId());
        Assert.assertEquals(result.getPatientName(), appointment.getPatientName());
        Assert.assertEquals(result.getDate(), appointment.getDate());

    }
}
