package com.employee.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest({EmployeeController.class})
@ActiveProfiles(value = "test")
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Value("${employee.get.url}")
    String geturl;

    @Value("${employee.post.url}")
    String posturl;

    @Value("${employee.put.url}")
    String puturl;

    @Value("${employee.delete.url}")
    String deleteurl;

    @Test
    public void testEmployeeGet() throws Exception
    {
        ResultActions responseEntity=mockMvc.perform(get(geturl).param("empName", "emp1"));
        responseEntity.andExpect(status().isOk());
        ObjectMapper mapper=new ObjectMapper();
        Employee result=mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),
                new TypeReference<Employee>() {
                });
        assertEquals("123", result.getEmpId());
        assertEquals("emp1", result.getEmpName());
        assertEquals(30000.0, result.getSalary(),0.0002);
        assertEquals("aws", result.getDepartment());
    }

    @Test
    public void testEmployeePost() throws Exception{
        Employee employee=createEmployee("123","emp1",20000,"aws");
        ResultActions responseEntity  = mockMvc.perform(post(posturl).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employee)).accept(MediaType.APPLICATION_JSON));
        responseEntity.andExpect(status().isOk());
        ObjectMapper mapper=new ObjectMapper();
        Employee result=mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),
                new TypeReference<Employee>() {
                });
        assertEquals("123", result.getEmpId());
        assertEquals("emp1", result.getEmpName());
        assertEquals(20000.0, result.getSalary(),0.0002);
        assertEquals("aws", result.getDepartment());
    }

    @Test
    public void testEmployeeUpdate() throws Exception{
        Employee employee=createEmployee("123","emp1",20000,"aws");
        ResultActions responseEntity  = mockMvc.perform(put(puturl)
                .param("empName","emp1").param("salary","30000.0"));
        responseEntity.andExpect(status().isOk());
        ObjectMapper mapper = new ObjectMapper();
        Employee result = mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),
                new TypeReference<Employee>() {
                });
        assertEquals("123", result.getEmpId());
        assertEquals("emp1", result.getEmpName());
        assertEquals(30000.0, result.getSalary(),0.0002);
        assertEquals("aws", result.getDepartment());

    }

    @Test
    public void testEmployeeDelete() throws Exception {
        ResultActions responseEntity = mockMvc.perform(delete(deleteurl).param("empName", "emp1"));
        responseEntity.andExpect(status().isOk());
        ObjectMapper mapper = new ObjectMapper();
        String result = responseEntity.andReturn().getResponse().getContentAsString();

        assertEquals("emp1", result);

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

    private Employee createEmployee(String empId,String empName,double salary,String department) {
        Employee employee=new Employee(empId, empName,salary,department);
        return employee;
    }

}
