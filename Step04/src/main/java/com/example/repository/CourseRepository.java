package com.example.repository;

import com.example.entity.Course;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;


@Repository
public class CourseRepository {

  final EntityManager em;

  public CourseRepository(EntityManager em) {
    this.em = em;
  }

  public Course findById(Long id) {
    return em.find(Course.class, id);
  }

}
