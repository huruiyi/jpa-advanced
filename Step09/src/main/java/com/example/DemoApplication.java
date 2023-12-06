package com.example;

import com.example.entity.Course;
import com.example.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

  private final CourseRepository repository;

  public DemoApplication(CourseRepository repository) {
    this.repository = repository;
  }

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Override
  public void run(String... arg0) {
    Course course = repository.findById(10001L);
    log.info("Course 10001 -> {}", course);
    repository.save(new Course("Microservices in 100 Steps"));
  }
}
