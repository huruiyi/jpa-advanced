package com.example.repository;

import com.example.DemoApplication;
import com.example.entity.Passport;
import com.example.entity.Student;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

  @Autowired
  StudentRepository repository;

  @Autowired
  EntityManager em;

  // Session & Session Factory

  // EntityManager & Persistence Context
  // Transaction

  @Test
  public void someTest() {
    repository.someOperationToUnderstandPersistenceContext();
  }

  @Test
  @Transactional
  public void retrieveStudentAndPassportDetails() {
    Student student = em.find(Student.class, 20001L);
    log.info("student -> {}", student);
    log.info("passport -> {}", student.getPassport());
  }

  @Test
  @Transactional
  public void retrievePassportAndAssociatedStudent() {
    Passport passport = em.find(Passport.class, 40001L);
    log.info("passport -> {}", passport);
    log.info("student -> {}", passport.getStudent());
  }

  @Test
  @Transactional
  public void retrieveStudentAndCourses() {
    Student student = em.find(Student.class, 20001L);

    log.info("student -> {}", student);
    log.info("courses -> {}", student.getCourses());
  }

}
