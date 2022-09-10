package com.rama.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rama.app.controller.AppController;
import com.rama.app.data.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Base64Utils;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({AppController.class})
@ActiveProfiles(value = "test")
public class AppControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Value("${employee.get.url}")
  String geturl;

  @Value("${employee.getPath.url}")
  String pathurl;

  @Value("${employee.getRequest.url}")
  String requesturl;


  @Value("${employee.post.url}")
  String posturl;

  @Value("${employee.put.url}")
  String puturl;

  @Value("${employee.delete.url}")
  String deleteurl;

  @Value("${user.user1.username}")
  String username1;

  @Value("${user.user1.password}")
  String password1;

  @Value("${admin.user1.username}")
  String admin_name1;

  @Value("${user.user1.password}")
  String admin_password1;


  @Test
  public void testEmployeeGet() throws Exception {
    ResultActions responseEntity = processApiRequest(geturl, HttpMethod.GET, null,
      null, username1, password1,null);
    responseEntity.andExpect(status().isOk());
    ObjectMapper mapper = new ObjectMapper();
    String result = responseEntity.andReturn().getResponse().getContentAsString();
    assertEquals("get employee ", result);
  }

  @Test
  public void testEmployeePost() throws Exception {
    Employee employee = createEmployee("test", "dev");
    ResultActions responseEntity = processApiRequest(posturl, HttpMethod.POST, null, employee, admin_name1, admin_password1,null);
    responseEntity.andExpect(status().isOk());
    ObjectMapper mapper = new ObjectMapper();
    Employee result = mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),
      new TypeReference<Employee>() {
      });

    assertEquals("test", result.getName());
    assertEquals("dev", result.getRole());

  }

  @Test
  public void testEmployeePut() throws Exception{
    Employee employee = new Employee();
    employee.setName("Test");
    employee.setRole("dev");
    ResultActions responseEntity = processApiRequest(puturl, HttpMethod.PUT, "test1", employee, admin_name1, admin_password1,null);
    responseEntity.andExpect(status().isOk());
    String result = responseEntity.andReturn().getResponse().getContentAsString();

    assertEquals("Employee{, name='Test', role='dev'}:Updated with name:test1", result);

  }

  @Test
  public void testEmployeeDelete() throws Exception{
    Employee employee = createEmployee("test", "dev");
    ResultActions responseEntity = processApiRequest(deleteurl, HttpMethod.DELETE, "test", employee, admin_name1, admin_password1,null);
    responseEntity.andExpect(status().isOk());
    String result = responseEntity.andReturn().getResponse().getContentAsString();

    assertEquals("test", result);

  }
  @Test
  public void testPathVar() throws Exception{
    Employee employee = createEmployee("test", "dev");
    ResultActions responseEntity = processApiRequest(pathurl, HttpMethod.GET, "Test1", employee, admin_name1, admin_password1,null);
    responseEntity.andExpect(status().isOk());
    String result = responseEntity.andReturn().getResponse().getContentAsString();

    assertEquals("Path Variable:Test1", result);

  }

  @Test
  public void testRequest() throws Exception{
    Employee employee = createEmployee("test", "dev");
    ResultActions responseEntity = processApiRequest(requesturl, HttpMethod.GET, "Test1", employee, admin_name1, admin_password1,null);
    responseEntity.andExpect(status().isOk());
    String result = responseEntity.andReturn().getResponse().getContentAsString();

    assertEquals("Request Param:Test1", result);

  }



  private ResultActions processApiRequest(String api, HttpMethod methodType, String name, Employee employee, String username, String password, List id) {
    ResultActions response = null;
    String secret = "Basic " + Base64Utils.encodeToString((username+":"+password).getBytes());//YWRtaW4xMjM6cGFzc3dvcmQ=
    try {
      switch (methodType) {
        case GET:
          response = mockMvc.perform(get(api,name,id).header(HttpHeaders.AUTHORIZATION, secret));
          break;
        case POST:
          response = mockMvc.perform(post(api).header(HttpHeaders.AUTHORIZATION, secret).contentType(MediaType.APPLICATION_JSON)
                  .content(asJsonString(employee)).accept(MediaType.APPLICATION_JSON));
          break;
        case PUT:
          response = mockMvc.perform(put(api, name).header(HttpHeaders.AUTHORIZATION, secret).contentType(MediaType.APPLICATION_JSON)
                  .content(asJsonString(employee)).accept(MediaType.APPLICATION_JSON));
          break;
        case DELETE:
          response = mockMvc.perform(delete(api, name));
          break;
        default:
          fail("Method Not supported");
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
      fail();
    }
    return response;
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

  private static Employee createEmployee(String name, String role) {
    Employee empEmployee = new Employee(name, role);
    return empEmployee;
  }
}
