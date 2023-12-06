package com.example.repository;

import com.example.entity.Course;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {

  final EntityManager em;

  public CourseRepository(EntityManager em) {
    this.em = em;
  }

  public Course findById(Long id) {
    return em.find(Course.class, id);
  }

  public Course save(Course course) {
    if (course.getId() == null) {
      em.persist(course);
    } else {
      em.merge(course);
    }
    return course;
  }

  public void deleteById(Long id) {
    Course course = findById(id);
    em.remove(course);
  }

  public void playWithEntityManager() {
    Course course1 = new Course("Web Services in 100 Steps");
    em.persist(course1);

    Course course2 = findById(10001L);

    course2.setName("JPA in 50 Steps - Updated");

  }
}
