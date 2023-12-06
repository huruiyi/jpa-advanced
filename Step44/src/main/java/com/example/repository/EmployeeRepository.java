package com.example.repository;

import com.example.entity.Employee;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeRepository {

  final EntityManager em;

  public EmployeeRepository(EntityManager em) {
    this.em = em;
  }

  public void insert(Employee employee) {
    em.persist(employee);
  }

  public List<Employee> retrieveAllEmployees() {
    return em.createQuery("select e from Employee e", Employee.class).getResultList();
  }
}
