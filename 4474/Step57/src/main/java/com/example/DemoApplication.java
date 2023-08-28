package com.example;

import com.example.repository.CourseRepository;
import com.example.repository.EmployeeRepository;
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

  @Autowired
  private EmployeeRepository employeeRepository;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Override
  public void run(String... arg0) throws Exception {
    // studentRepository.saveStudentWithPassport();
    // repository.playWithEntityManager();
    // courseRepository.addHardcodedReviewsForCourse();
    // List<Review> reviews = new ArrayList<>();

    // reviews.add(new Review("5", "Great Hands-on Stuff."));
    // reviews.add(new Review("5", "Hatsoff."));

    // courseRepository.addReviewsForCourse(10003L, reviews );
    // studentRepository.insertHardcodedStudentAndCourse();
    // studentRepository.insertStudentAndCourse(new Student("Jack"),
    // new Course("Microservices in 100 Steps"));

    // Jack FullTimeEmployee salary - 10000$
    // Jill PartTimeEmployee - 50$ per hour
		/*
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

		log.info("Full Time Employees -> {}", 
				employeeRepository.retrieveAllFullTimeEmployees());
		
		log.info("Part Time Employees -> {}", 
				employeeRepository.retrieveAllPartTimeEmployees());*/
  }
}
