package com.batm.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batm.exercise.models.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
  // Employee findByEmail(String email);
}
