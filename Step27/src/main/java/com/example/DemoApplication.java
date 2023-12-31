package com.example;

import com.example.repository.CourseRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private StudentRepository studentRepository;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Override
  public void run(String... arg0) throws Exception {
    //studentRepository.saveStudentWithPassport();
    //courseRepository.playWithEntityManager();
  }
}
