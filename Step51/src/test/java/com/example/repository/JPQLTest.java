package com.example.repository;

import com.example.DemoApplication;
import com.example.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest(classes = DemoApplication.class)
public class JPQLTest {

  @Autowired
  EntityManager em;

  @Test
  public void jpql_basic() {
    Query query = em.createNamedQuery("query_get_all_courses");
    List resultList = query.getResultList();
    log.info("Select  c  From Course c -> {}", resultList);
  }

  @Test
  public void jpql_typed() {
    TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);

    List<Course> resultList = query.getResultList();

    log.info("Select  c  From Course c -> {}", resultList);
  }

  @Test
  public void jpql_where() {
    TypedQuery<Course> query = em.createNamedQuery("query_get_100_Step_courses", Course.class);

    List<Course> resultList = query.getResultList();

    log.info("Select  c  From Course c where name like '%100 Steps'-> {}", resultList);
    // [Course[Web Services in 100 Steps], Course[Spring Boot in 100 Steps]]
  }

  @Test
  public void jpql_courses_without_students() {
    TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty", Course.class);
    List<Course> resultList = query.getResultList();
    log.info("Results -> {}", resultList);
    // [Course[Spring in 50 Steps]]
  }


  @Test
  public void jpql_courses_with_atleast_2_students() {
    TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) >= 2", Course.class);
    List<Course> resultList = query.getResultList();
    log.info("Results -> {}", resultList);
    //[Course[JPA in 50 Steps]]
  }

  @Test
  public void jpql_courses_ordered_by_students() {
    TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students) desc", Course.class);
    List<Course> resultList = query.getResultList();
    log.info("Results -> {}", resultList);
  }

}