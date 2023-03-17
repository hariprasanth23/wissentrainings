package com.wissen.controller;

import com.wissen.entity.employee.Employee;
import com.wissen.entity.partner.Partner;
import com.wissen.repository.employee.EmployeeRepository;
import com.wissen.repository.partner.PartnerRepository;
import com.wissen.service.EmployeeService;
import com.wissen.utility.Constant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PartnerRepository partnerRepository;

    @PostMapping(Constant.EMPLOYEE_BULK_UPLOAD)
    public void uploadBulkEmployee(){

        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee(1,"user1","DOB",1000,"email1","mobile1","HR");
        Employee employee2 = new Employee(2,"user2","DOB",1000,"email2","mobile2","Technology");
        Employee employee3 = new Employee(3,"user3","DOB",1000,"email3","mobile3","Partners");
        Employee employee4 = new Employee(4,"user4","DOB",1000,"email4","mobile4","Partners");

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);

        logger.info("Logging of "+ employeeList);

        employeeService.bulkUpload(employeeList);

    }

    @GetMapping("/getAllPartners")
    public List<Partner> getAllPartners(){
       return partnerRepository.findAll();
    }

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

}
