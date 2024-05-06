package com.batm.exercise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.batm.exercise.models.Employee;
import com.batm.exercise.repository.EmployeeRepository;

@Controller
@RequestMapping("employees")
public class EmployeeController {
  
  @Autowired
  private EmployeeRepository employeeRepository;

  @GetMapping
  public String index(Model model) {
    model.addAttribute("employees", employeeRepository.findAll());
    return "employee/index";
  }

  @GetMapping(value = {"form", "form/{id}"})
  public String form(@PathVariable(required = false) Integer id, Model model) {
    if (id != null) {
      model.addAttribute("employee", employeeRepository.findById(id).get());
    } else {
      model.addAttribute("employee", new Employee());
    }
    return "employee/form";
  }

  @PostMapping("submit")
  public String insert(Employee employee) {
    try {
      employeeRepository.save(employee);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:/employees";
  }

  @PostMapping("delete/{id}")
  public String delete(@PathVariable("id") Integer id) {
    try {
      employeeRepository.deleteById(id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:/employees";
  }
}
