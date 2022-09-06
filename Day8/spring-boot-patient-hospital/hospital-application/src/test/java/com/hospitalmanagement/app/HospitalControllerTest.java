package com.hospitalmanagement.app;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospitalmanagement.app.Hospital;
import com.hospitalmanagement.app.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
    @RunWith(SpringRunner.class)
    @WebMvcTest({HospitalController.class})
    @ActiveProfiles(value = "test")
    public class HospitalControllerTest {
        @Autowired
        private MockMvc mockMvc;
        @Value("${get.hospital.url}")
        String getPatientUrl;

        @Value("${post.hospital.url}")
        String postPatientUrl;

        @Value("${put.hospital.url}")
        String putPatientUrl;

        @Value("${delete.hospital.url}")
        String deletePatientUrl;

        @Test
        public void testHospitalGet() throws Exception {
            ResultActions responseEntity  = mockMvc.perform(get(getPatientUrl).param("name","Hos1"));
            responseEntity.andExpect(status().isOk());
            ObjectMapper mapper = new ObjectMapper();
            Hospital result = mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),
                    new TypeReference<Hospital>() {
                    });
            assertEquals("Hos1", result.getHospitalName());
            assertEquals("add1", result.getAddress());
            assertEquals("id1", result.getHospId());
        }

        @Test
        public void testHospitalPost() throws Exception {
            Hospital patient= createHospital("Hos1","add1","id1",null);
            ResultActions responseEntity  = mockMvc.perform(post(postPatientUrl).contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(patient)).accept(MediaType.APPLICATION_JSON));
            responseEntity.andExpect(status().isOk());
            ObjectMapper mapper = new ObjectMapper();
            Hospital result = mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),
                    new TypeReference<Hospital>() {
                    });
            assertEquals("Hos1", result.getHospitalName());
            assertEquals("add1", result.getAddress());
            assertEquals("id1", result.getHospId());
        }

        @Test
        public void testHospitalUpdate() throws Exception {
            Hospital patient= createHospital("Hos1","add1","id1", null);
            ResultActions responseEntity  = mockMvc.perform(put(putPatientUrl)
                    .param("hospitalName","Hos1").param("address","add2"));
            responseEntity.andExpect(status().isOk());
            ObjectMapper mapper = new ObjectMapper();
            Hospital result = mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),
                    new TypeReference<Hospital>() {
                    });
            assertEquals("Hos11", result.getHospitalName());
            assertEquals("add2", result.getAddress());
            assertEquals("id1", result.getHospId());
        }

        @Test
        public void testHospitalDelete() throws Exception {
            ResultActions responseEntity  = mockMvc.perform(delete(deletePatientUrl).param("name","test"));
            responseEntity.andExpect(status().isOk());
            ObjectMapper mapper = new ObjectMapper();
            String result=responseEntity.andReturn().getResponse().getContentAsString();

            assertEquals("test", result);

        }


        private String asJsonString(final Object obj) {
            try {
                final ObjectMapper mapper = new ObjectMapper();
                final String jsonContent = mapper.writeValueAsString(obj);
                return jsonContent;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private static Hospital createHospital(String name, String address, String id, List<Patient> patients) {
            Hospital hospital = new Hospital(name,address,id,patients);
            return hospital;
        }

    }
