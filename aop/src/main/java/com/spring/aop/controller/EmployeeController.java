package com.spring.aop.controller;


import com.spring.aop.model.Employee;
import com.spring.aop.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public Employee save(@RequestBody Employee employee ){
        return employeeService.save(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee findById( @PathVariable(value = "id") Integer id ){
        return employeeService.findById(id);
    }


}
