package com.batm.exercise.models;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "tb_m_role")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;

  @OneToMany(mappedBy = "role")
  private List<User> users;

  public Role() {
  }

  public Role(Integer id, String name, List<User> users) {
    this.id = id;
    this.name = name;
    this.users = users;
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

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
}
