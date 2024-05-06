package com.batm.exercise.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.batm.exercise.DTO.ForgotPasswordDTO;
import com.batm.exercise.DTO.LoginDTO;
import com.batm.exercise.models.*;
import com.batm.exercise.repository.EmployeeRepository;
import com.batm.exercise.repository.UserRepository;

@Controller
@RequestMapping("auth")
public class AuthController {
  
  @Autowired
  private EmployeeRepository employeeRepository;
  
  @Autowired
  private UserRepository userRepository;

  @GetMapping("form")
  public String form(Model model) {
    model.addAttribute("loginData", new LoginDTO());
    return "auth/login";
  }

  @PostMapping("login")
  public String login(LoginDTO loginData, Model model) {
    String email = loginData.getEmail();
    String password = loginData.getPassword();

    List<Employee> allEmployee = employeeRepository.findAll();
    Employee employee = null;
    for (Employee emp: allEmployee) {
      if (emp.getEmail().equals(email)) {
        employee = emp;
        break;
      }
    }

    // Employee employee = employeeRepository.findByEmail(email);
    
    if (employee == null) {
      return "redirect:form?error=true";
    }
    
    Optional<User> optional = userRepository.findById(employee.getId());

    if (optional.isEmpty()) {
      return "redirect:form?error=true";
    }

    if (!optional.get().getPassword().equals(password)) {
      return "redirect:form?error=true";
    }

    model.addAttribute("employee", employee);
    return "main/index";
  }

    @GetMapping("forgotPassword")
    public String forgotPassword(Model model){
        model.addAttribute("forgotPasswordDTO", new ForgotPasswordDTO());
        return "auth/forgotPassword";
    }
   
    @PostMapping("resetPassword")
    public String resetPassword(ForgotPasswordDTO forgotpassData) {
        String email = forgotpassData.getEmail();

        List<Employee> allEmployee = employeeRepository.findAll();
        for (Employee e : allEmployee) {
            if(e.getEmail().equals(email)){
                String newPassword = forgotpassData.getNewPassword();
                e.getUser().setPassword(newPassword);
                employeeRepository.save(e);
                return "redirect:/auth/form";
            }
        }    
        return "redirect:/auth/forgotPassword";
    };
}
