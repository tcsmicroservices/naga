package com.mongo.app.controller;


import com.mongo.app.Repository.PrescriptionRepository;
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
public class PrescriptionControllerTest {

    @InjectMocks
    private PrescriptionController prescriptionController;
    @Mock
    private PrescriptionRepository prescriptionRepository;
    @Test
    public void viewPrescriptionTest(){
        List<Prescription> prescriptions= new ArrayList();
        Prescription mockPrescription = mock(Prescription.class);
        Prescription dummy = new Prescription() ;
        dummy.setPrescriptionId(1);
        dummy.setAppointmentId(1);
        dummy.setDescription("perscription1");
        dummy.setPatientName("pat1");
        dummy.setDoctorName("doc1");
        prescriptions.add(dummy);
        when(prescriptionRepository.findByPatientName(anyString())).thenReturn(prescriptions);
        List<Prescription>result= prescriptionRepository.findByPatientName("pat1");
        Assert.assertEquals(result.get(0).getPrescriptionId(),dummy.getPrescriptionId());
        Assert.assertEquals(result.get(0).getAppointmentId(),dummy.getAppointmentId());
        Assert.assertEquals(result.get(0).getDescription(),dummy.getDescription());
        Assert.assertEquals(result.get(0).getPatientName(), dummy.getPatientName());
        Assert.assertEquals(result.get(0).getDoctorName(), dummy.getDoctorName());

    }
    @Test
    public void savePrescription(){
        Prescription mockPrescription = mock(Prescription.class);
        Prescription dummy = new Prescription(1,1, "prescription1","pat1","doc1");
        when(prescriptionRepository.save(any(Prescription.class))).thenReturn(dummy);
        Prescription result=prescriptionRepository.save(dummy);
        Assert.assertEquals(result.getPrescriptionId(),dummy.getPrescriptionId());
        Assert.assertEquals(result.getAppointmentId(),dummy.getAppointmentId());
        Assert.assertEquals(result.getDescription(),dummy.getDescription());
        Assert.assertEquals(result.getPatientName(), dummy.getPatientName());
        Assert.assertEquals(result.getDoctorName(), dummy.getDoctorName());

    }
}
