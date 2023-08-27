package com.example.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.example.DemoApplication;
import com.example.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@Slf4j
@SpringBootTest(classes = DemoApplication.class)
public class CourseRepositoryTest {

  @Autowired
  CourseRepository repository;

  @Test
  public void findById_basic() {
    Course course = repository.findById(10001L);
    assertEquals("JPA in 50 Steps", course.getName());
  }

  @Test
  @DirtiesContext
  public void deleteById_basic() {
    repository.deleteById(10002L);
    assertNull(repository.findById(10002L));
  }

  @Test
  @DirtiesContext
  public void save_basic() {
    // get a course
    Course course = repository.findById(10001L);
    assertEquals("JPA in 50 Steps", course.getName());

    // update details
    course.setName("JPA in 50 Steps - Updated");

    repository.save(course);

    // check the value
    Course course1 = repository.findById(10001L);
    assertEquals("JPA in 50 Steps - Updated", course1.getName());
  }

}
