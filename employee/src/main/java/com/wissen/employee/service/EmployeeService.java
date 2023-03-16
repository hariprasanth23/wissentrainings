package com.wissen.employee.service;

import com.wissen.employee.entity.Employee;
import com.wissen.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    public void bulkupload(List<Employee> employeeList){
        employeeRepository.saveAll(employeeList);
    }
}
