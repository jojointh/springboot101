package com.training.springboot.SpringbootPractices.controller;

import com.training.springboot.SpringbootPractices.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class EmployeeController {

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> listAllAnnotation() {

        System.out.println("### Enter to GET: /employees ###");

        List<Employee> employeeList = new ArrayList<>();

        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Surasak");
        employee.setLastName("Ad.");
        employee.setAge(20);

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setFirstName("Surasak2");
        employee2.setLastName("A.");
        employee2.setAge(21);

        employeeList.add(employee);
        employeeList.add(employee2);

        return employeeList;
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable Integer id) {

        System.out.println("### id: " + id);

        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Surasak");
        employee.setLastName("A.");
        employee.setAge(20);

        return employee;
    }

}
