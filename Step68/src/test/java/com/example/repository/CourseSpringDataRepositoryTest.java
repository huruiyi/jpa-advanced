package com.example.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.DemoApplication;
import com.example.entity.Course;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


@Slf4j
@SpringBootTest(classes = DemoApplication.class)
public class CourseSpringDataRepositoryTest {

  @Autowired
  CourseSpringDataRepository repository;

  @Test
  public void findById_CoursePresent() {
    Optional<Course> courseOptional = repository.findById(10001L);
    assertTrue(courseOptional.isPresent());
  }

  @Test
  public void findById_CourseNotPresent() {
    Optional<Course> courseOptional = repository.findById(20001L);
    assertFalse(courseOptional.isPresent());
  }

  @Test
  public void playingAroundWithSpringDataRepository() {
    //Course course = new Course("Microservices in 100 Steps");
    //repository.save(course);

    //course.setName("Microservices in 100 Steps - Updated");
    //repository.save(course);
    log.info("Courses -> {} ", repository.findAll());
    log.info("Count -> {} ", repository.count());
  }

  @Test
  public void sort() {
    Sort sort = Sort.by(Sort.Direction.ASC, "name");
    log.info("Sorted Courses -> {} ", repository.findAll(sort));
  }

  @Test
  public void pagination() {
    PageRequest pageRequest = PageRequest.of(0, 3);

    Page<Course> firstPage = repository.findAll(pageRequest);
    log.info("First Page -> {} ", firstPage);
  }

}
