package com.employee.app;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {
    private Map<String,Employee> employeeMap=new HashMap<String,Employee>();

    @GetMapping("/get/employee")
    public Employee getEmployee(@RequestParam String empName){
        Employee result=employeeMap.get(empName);
        return result;
    }

    @PostMapping("/save/employee")
    public void saveEmployee(@RequestBody Employee employee){
        String empName= employee.getEmpName();
        employeeMap.put(empName,employee);
    }

    @PutMapping("/update/employee")
    public Employee updateEmployee(@RequestParam String empName,@RequestParam double salary){
        Employee result= employeeMap.get(empName);
        result.setSalary(salary);
        employeeMap.put(empName,result);
        return result;

    }

    @DeleteMapping("/remove/employee")
    public void deleteEmployee(@RequestParam String empName){
        employeeMap.remove(empName);
    }

}
