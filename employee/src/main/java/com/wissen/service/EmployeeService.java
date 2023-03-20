package com.wissen.service;

import com.wissen.entity.Employee;
import com.wissen.entity.Partner;
import com.wissen.repository.employee.EmployeeRepository;
import com.wissen.repository.partner.PartnerRepository;
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

    @Autowired
    private PartnerRepository partnerRepository;

    public void bulkUpload(List<Employee> employeeList){

        List<Partner> partnerList = employeeList.parallelStream().
                filter(e->e.getEmployeeType().equals("Partners"))
                .map(this::mapToPartner).toList();
        logger.info("Partners  List"+ partnerList);
        partnerRepository.saveAll(partnerList);

        List<Employee> employeeList1 = employeeList.parallelStream().filter(e->!e.getEmployeeType().equals("Partners")).toList();
        logger.info("Other Employee  List"+ employeeList1);
        employeeRepository.saveAll(employeeList1);

    }

    private Partner mapToPartner(Employee employee) {
        Partner partner = new Partner();
        partner.setId(employee.getId());
        partner.setUsername(employee.getUsername());
        partner.setDateOfBirth(employee.getDateOfBirth());
        partner.setSalary(employee.getSalary());
        partner.setEmail(employee.getEmail());
        partner.setMobile(employee.getMobile());
        partner.setEmployeeType(employee.getEmployeeType());

        return partner;
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Partner savePartner(Partner partner){
        return partnerRepository.save(partner);
    }
    public List<Partner> getAllPartner(){
        return partnerRepository.findAll();
    }


}
