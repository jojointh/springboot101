package com.training.springboot.SpringbootPractices.repository;

import com.training.springboot.SpringbootPractices.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCrudRepository extends JpaRepository<Employee, Integer> {

}