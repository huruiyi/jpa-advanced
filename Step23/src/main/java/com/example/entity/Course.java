package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(value = {
    @NamedQuery(name = "query_get_all_courses", query = "Select  c  From Course c"),
    @NamedQuery(name = "query_get_100_Step_courses", query = "Select  c  From Course c where name like '%100 Steps'")})
public class Course {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false)
  private String name;

  @UpdateTimestamp
  private LocalDateTime lastUpdatedDate;

  @CreationTimestamp
  private LocalDateTime createdDate;

  protected Course() {
  }

  public Course(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String toString() {
    return String.format("Course[%s]", name);
  }
}
