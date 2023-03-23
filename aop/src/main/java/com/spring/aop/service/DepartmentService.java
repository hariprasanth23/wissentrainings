package com.spring.aop.service;


import com.spring.aop.aspect.CustomAnnotation;
import com.spring.aop.model.Department;
import com.spring.aop.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department ){
        return departmentRepository.save(department);
    }

    //@CustomAnnotation
    public Department findById(Integer id ){
        return departmentRepository.findById(id).orElseThrow();
    }
}
