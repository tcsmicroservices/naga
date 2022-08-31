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
        if(result==null){
           Employee employee=new Employee("123","emp1", 20000,"aws");
           return employee;
        }
        else {
            return result;
        }
    }

    @PostMapping("/save/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        String empName= employee.getEmpName();
        employeeMap.put(empName,employee);
        return employee;
    }

    @PutMapping("update/employee")
    public Employee updateEmployee(@RequestParam String empName,@RequestParam double salary){
        Employee result= employeeMap.get(empName);
        if (result == null) {
            Employee employee = new Employee("123", "emp1", 20000, "aws");
            employee.setSalary(salary);
            employeeMap.put(empName, employee);
            return employee;
        }
      else{
                result.setSalary(salary);
                employeeMap.put(empName, result);
                return result;
            }

    }

    @DeleteMapping("remove/employee")
    public String deleteEmployee(@RequestParam String empName){
        employeeMap.remove(empName);
        return empName;
    }

}
