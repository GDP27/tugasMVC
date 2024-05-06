package com.batm.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batm.exercise.models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
  
}
