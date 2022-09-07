package com.mongo.app.controller;


import com.mongo.app.Repository.AppointmentRepository;
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

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DoctorControllerTest {

    @InjectMocks
    private DoctorController doctorController;
    @Mock
    private AppointmentRepository appointmentRepository;


    @Test
    public void readAppointmentsTest(){
        List<Appointment> appointments= new ArrayList();
        Appointment mockAppointment = mock(Appointment.class);
        Appointment dummyAppointment = new Appointment();
        dummyAppointment.setAppointmentId(1);
        dummyAppointment.setPatientName("pat1");
        dummyAppointment.setDoctorName("doc1");
        dummyAppointment.setDate("7 Sept");
        dummyAppointment.setPrescription(new Prescription(1,1, "Prescription1","pat1","doc1"));
        appointments.add(dummyAppointment);
        when(appointmentRepository.findByDoctorName(anyString())).thenReturn(appointments);
        List<Appointment> result = appointmentRepository.findByDoctorName("doc1");
        Assert.assertEquals(result.get(0).getAppointmentId(), dummyAppointment.getAppointmentId());
        Assert.assertEquals(result.get(0).getPatientName(), dummyAppointment.getPatientName());
        Assert.assertEquals(result.get(0).getDoctorName(), dummyAppointment.getDoctorName());
        Assert.assertEquals(result.get(0).getDate(), dummyAppointment.getDate());
        Assert.assertEquals(result.get(0).getPrescription(), dummyAppointment.getPrescription());

    }
}
