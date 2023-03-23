package com.spring.aop.controller;


import com.spring.aop.model.Department;
import com.spring.aop.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/saveDepartment")
    public Department save(@RequestBody Department department ){
        return departmentService.save(department);
    }

    @GetMapping("/department/{id}")
    public Department findById( @PathVariable(value = "id") Integer id ){
        return departmentService.findById(id);
    }
}
