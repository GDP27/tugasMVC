package com.batm.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batm.exercise.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
  
}
