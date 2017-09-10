package com.training.springboot.SpringbootPractices.controller;

import com.training.springboot.SpringbootPractices.domain.Employee;
import com.training.springboot.SpringbootPractices.repository.EmployeeCrudRepository;
import com.training.springboot.SpringbootPractices.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeCrudRepository crudRepository;

    @GetMapping
    public List<Employee> listAllAnnotation() {

        System.out.println("### Enter to GET: /employees ###");

        return crudRepository.findAll();
//        return employeeRepository.findAllByNativeSQL();
//        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id) {

        System.out.println("### id: " + id);

        Employee employee = employeeRepository.findById(id);

        return employee;
    }

    @GetMapping("/lastname/{name}")
    public Employee getEmployee(@PathVariable String name) {

        Employee employee = employeeRepository.findByLastName(name);

        return employee;
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employeeParam) {
        System.out.println("## Enter to POST: /employees");
        System.out.println("First Name : " + employeeParam.getFirstName());

        // save to DB
        employeeRepository.save(employeeParam);

        return employeeParam;
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeParam) {
        System.out.println("## Enter to PUT: /employees/" + id);
        System.out.println("First Name : " + employeeParam.getFirstName());

        Employee employee = employeeRepository.findById(id);
        employee.setFirstName(employeeParam.getFirstName());
        employee.setLastName(employeeParam.getLastName());
        employee.setAge(employeeParam.getAge());

        employeeRepository.save(employee);

        return employeeParam;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) {
        System.out.println("## Enter to DELETE: /employees/" + id);

        Employee employee = getEmployee(id);
        employeeRepository.delete(employee);
    }

}
