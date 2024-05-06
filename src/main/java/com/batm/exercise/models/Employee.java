package com.batm.exercise.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_m_employee")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String email;

  @OneToOne(mappedBy = "employee")
  private User user;

  public Employee() {
  }

  public Employee(Integer id, String name, String email, User user) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.user = user;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
