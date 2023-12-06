package com.example;

import com.example.entity.Review;
import com.example.repository.CourseRepository;
import com.example.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

  private final CourseRepository courseRepository;

  private final StudentRepository studentRepository;

  public DemoApplication(CourseRepository courseRepository, StudentRepository studentRepository) {
    this.courseRepository = courseRepository;
    this.studentRepository = studentRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Override
  public void run(String... arg0) throws Exception {
    //studentRepository.saveStudentWithPassport();
    //repository.playWithEntityManager();
    //courseRepository.addHardcodedReviewsForCourse();
    List<Review> reviews = new ArrayList<>();

    reviews.add(new Review("5", "Great Hands-on Stuff."));
    reviews.add(new Review("5", "Hatsoff."));

    courseRepository.addReviewsForCourse(10003L, reviews);
  }
}
