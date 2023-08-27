package com.example.repository;

import com.example.entity.Passport;
import com.example.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {

  final EntityManager em;

  public StudentRepository(EntityManager em) {
    this.em = em;
  }

  public Student findById(Long id) {
    return em.find(Student.class, id);
  }

  public Student save(Student student) {
    if (student.getId() == null) {
      em.persist(student);
    } else {
      em.merge(student);
    }
    return student;
  }

  public void deleteById(Long id) {
    Student student = findById(id);
    em.remove(student);
  }

  public void saveStudentWithPassport() {
    Passport passport = new Passport("Z123456");
    em.persist(passport);

    Student student = new Student("Mike");

    student.setPassport(passport);
    em.persist(student);
  }

  public void someOperationToUnderstandPersistenceContext() {
    //Database Operation 1 - Retrieve student
    Student student = em.find(Student.class, 20001L);
    //Persistence Context (student)

    //Database Operation 2 - Retrieve passport
    Passport passport = student.getPassport();
    //Persistence Context (student, passport)

    //Database Operation 3 - update passport
    passport.setNumber("E123457");
    //Persistence Context (student, passport++)

    //Database Operation 4 - update student
    student.setName("Ranga - updated");
    //Persistence Context (student++ , passport++)
  }

}
