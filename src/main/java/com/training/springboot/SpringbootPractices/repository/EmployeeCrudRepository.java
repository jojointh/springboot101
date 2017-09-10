package com.training.springboot.SpringbootPractices.repository;

import com.training.springboot.SpringbootPractices.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeCrudRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByFirstName(String firstName);
    // findBy...
    Employee findByLastName(String lastName);

}