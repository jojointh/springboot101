package com.training.springboot.SpringbootPractices.controller;

import com.training.springboot.SpringbootPractices.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class EmployeeController {

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public Employee listAllAnnotation() {

        System.out.println("### Enter to GET: /employees ###");

        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Surasak");
        employee.setLastName("Ad.");
        employee.setAge(20);

        return employee;
    }
}
