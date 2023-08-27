package com.example.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.DemoApplication;
import com.example.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoApplication.class)
public class CourseRepositoryTest {

  @Autowired
  CourseRepository repository;

  @Test
  public void findById_basic() {
    Course course = repository.findById(10001L);
    assertEquals("JPA in 50 Steps", course.getName());
  }

}
