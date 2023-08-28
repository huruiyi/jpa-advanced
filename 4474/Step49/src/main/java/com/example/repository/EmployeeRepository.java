package com.example.repository;

import com.example.entity.Employee;
import com.example.entity.FullTimeEmployee;
import com.example.entity.PartTimeEmployee;
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

  public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
    return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
  }

  public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
    return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
  }

}
