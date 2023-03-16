package com.wissen.employee.controller;

import com.wissen.employee.entity.Employee;
import com.wissen.employee.service.EmployeeService;
import com.wissen.employee.utility.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(Constant.EMPLOYEE_BULK_UPLOAD)
    public void uploadBulkEmployee(@RequestBody List<Employee> employeeList){

        employeeService.bulkupload(employeeList);

    }


}
