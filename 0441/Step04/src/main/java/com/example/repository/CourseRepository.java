package com.example.repository;

import com.example.entity.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
         return em.find(Course.class, id);
    }

    //public Course save(Course course) -> insert or update

    //public void deleteById(Long id)

}
