package com.example.repository;

import com.example.DemoApplication;
import com.example.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@SpringBootTest(classes = DemoApplication.class)
public class NativeQueriesTest {

  @Autowired
  EntityManager em;

  @Test
  public void native_queries_basic() {
    Query query = em.createNativeQuery("SELECT * FROM COURSE", Course.class);
    List resultList = query.getResultList();
    log.info("SELECT * FROM COURSE  -> {}", resultList);
    //SELECT * FROM COURSE  -> [Course[Web Services in 100 Steps], Course[JPA in 50 Steps - Updated], Course[Spring in 50 Steps], Course[Spring Boot in 100 Steps]]
  }

  @Test
  public void native_queries_with_parameter() {
    Query query = em.createNativeQuery("SELECT * FROM COURSE where id = ?", Course.class);
    query.setParameter(1, 10001L);
    List resultList = query.getResultList();
    log.info("SELECT * FROM COURSE  where id = ? -> {}", resultList);
    //[Course[JPA in 50 Steps - Updated]]
  }

  @Test
  public void native_queries_with_named_parameter() {
    Query query = em.createNativeQuery("SELECT * FROM COURSE where id = :id", Course.class);
    query.setParameter("id", 10001L);
    List resultList = query.getResultList();
    log.info("SELECT * FROM COURSE  where id = :id -> {}", resultList);
    //[Course[JPA in 50 Steps - Updated]]
  }

  @Test
  @Transactional
  public void native_queries_to_update() {
    Query query = em.createNativeQuery("Update COURSE set last_updated_date=sysdate()");
    int noOfRowsUpdated = query.executeUpdate();
    log.info("noOfRowsUpdated  -> {}", noOfRowsUpdated);
    //SELECT * FROM COURSE  -> [Course[Web Services in 100 Steps], Course[JPA in 50 Steps - Updated], Course[Spring in 50 Steps], Course[Spring Boot in 100 Steps]]
  }


}
