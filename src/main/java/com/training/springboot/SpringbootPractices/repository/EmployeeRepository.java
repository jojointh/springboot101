package com.training.springboot.SpringbootPractices.repository;

import com.training.springboot.SpringbootPractices.domain.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee");
        return query.getResultList();
    }

    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    public Employee findByLastName(String  lastName) {
        Query query = entityManager.createQuery("from Employee e where e.lastName = :LAST_NAME");
        query.setParameter("LAST_NAME", lastName);
        List resultList = query.getResultList();

        return resultList.isEmpty()? null : (Employee) resultList.get(0);
    }

    public List<Employee> findAllByNativeSQL() {
        // use native query, in case want to do advance query like JOIN which JQL not support
        Query nativeQuery = entityManager.createNativeQuery("select e.id, e.first_name, e.last_name from EMPLOYEE e");
        List<Object[]> resultList = nativeQuery.getResultList();

        List<Employee> response = new ArrayList<>();

        for(Object obj[] : resultList) {
            Employee employee = new Employee();
            employee.setId((Integer) obj[0]);
            employee.setFirstName((String) obj[1]);
            employee.setLastName((String) obj[2]);
            response.add(employee);
        }

        return response;
    }

    @Transactional
    public Employee save(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Transactional
    public void delete(Employee employee) {
        entityManager.remove(employee);
    }

}
