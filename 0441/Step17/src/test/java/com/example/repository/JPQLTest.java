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
    Query query = em.createQuery("Select  c  From Course c");
    List resultList = query.getResultList();
    log.info("Select  c  From Course c -> {}", resultList);
  }

  @Test
  public void jpql_typed() {
    TypedQuery<Course> query = em.createQuery("Select  c  From Course c", Course.class);

    List<Course> resultList = query.getResultList();

    log.info("Select  c  From Course c -> {}", resultList);
  }

  @Test
  public void jpql_where() {
    TypedQuery<Course> query = em.createQuery("Select  c  From Course c where name like '%100 Steps'", Course.class);

    List<Course> resultList = query.getResultList();

    log.info("Select  c  From Course c where name like '%100 Steps'-> {}", resultList);
    //[Course[Web Services in 100 Steps], Course[Spring Boot in 100 Steps]]
  }

}
