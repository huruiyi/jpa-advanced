package com.example.repository;

import com.example.DemoApplication;
import com.example.entity.Course;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Subgraph;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = DemoApplication.class)
public class PerformanceTuningTest {

  @Autowired
  EntityManager em;
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Test
  @Transactional
  public void creatingNPlusOneProblem() {
    List<Course> courses = em
        .createNamedQuery("query_get_all_courses", Course.class)
        .getResultList();
    for (Course course : courses) {
      logger.info("Course -> {} Students -> {}", course, course.getStudents());
    }
  }

  @Test
  @Transactional
  public void solvingNPlusOneProblem_EntityGraph() {

    EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
    Subgraph<Object> subGraph = entityGraph.addSubgraph("students");

    List<Course> courses = em
        .createNamedQuery("query_get_all_courses", Course.class)
        .setHint("jakarta.persistence.loadgraph", entityGraph)
        .getResultList();

    for (Course course : courses) {
      logger.info("Course -> {} Students -> {}", course, course.getStudents());
    }
  }

  @Test
  @Transactional
  public void solvingNPlusOneProblem_JoinFetch() {
    List<Course> courses = em
        .createNamedQuery("query_get_all_courses_join_fetch", Course.class)
        .getResultList();
    for (Course course : courses) {
      logger.info("Course -> {} Students -> {}", course, course.getStudents());
    }
  }

}
