package com.training.springboot.SpringbootPractices.controller;

import com.training.springboot.SpringbootPractices.domain.Employee;
import com.training.springboot.SpringbootPractices.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
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

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {

        System.out.println("### id: " + id);

        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Surasak");
        employee.setLastName("A.");
        employee.setAge(20);

        return employee;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employeeParam) {
        System.out.println("## Enter to POST: /employees");
        System.out.println("First Name : " + employeeParam.getFirstName());

        // TODO: save to DB
        return employeeParam;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeParam) {
        System.out.println("## Enter to PUT: /employees/" + id);
        System.out.println("First Name : " + employeeParam.getFirstName());

        // TODO: update to DB
        return employeeParam;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        System.out.println("## Enter to DELETE: /employees/" + id);

        // TODO: delete a record in DB
    }

}
