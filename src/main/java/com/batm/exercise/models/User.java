package com.batm.exercise.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_m_user")
public class User {
  @Id
  private Integer id;
  private String password;

  @OneToOne
  @JoinColumn(name = "id")
  private Employee employee;

  @ManyToOne
  @JoinColumn(name = "role_id")
  private Role role;

  public User() {
  }

  public User(Integer id, String password, Employee employee, Role role) {
    this.id = id;
    this.password = password;
    this.employee = employee;
    this.role = role;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
