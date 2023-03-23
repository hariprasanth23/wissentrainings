package com.wissen.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.wissen.entity.Employee;
import com.wissen.entity.Partner;
import com.wissen.repository.employee.EmployeeRepository;
import com.wissen.repository.partner.PartnerRepository;
import com.wissen.utility.Constant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PartnerRepository partnerRepository;

    public void bulkUpload() throws CsvValidationException, IOException {

        List<Employee> employeeList = loadDataFromExcel(Constant.FILE_LOCATION+Constant.FILE_NAME);

        List<Partner> partnerList = employeeList.parallelStream().
                filter(e->e.getEmployeeType().equals("Partners"))
                .map(this::mapToPartner).toList();
        partnerRepository.saveAll(partnerList);

        List<Employee> employeeList1 = employeeList.parallelStream().filter(e->!e.getEmployeeType().equals("Partners")).toList();
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

    public List<Employee> loadDataFromExcel(String fileLocation) throws IOException, CsvValidationException {
        CSVReader reader = new CSVReaderBuilder(new FileReader(fileLocation)).build();
        String[] nextLine;
        List<Employee> employeeList = new ArrayList<>();

        while((nextLine = reader.readNext()) != null){
            if(!nextLine[2].equals("dateOfBirth") && !(nextLine[0].isEmpty() || nextLine[0].isBlank()) ){
                Employee employee = Employee.builder()
                        .id(Integer.parseInt(nextLine[0]))
                        .username(nextLine[1])
                        .dateOfBirth(nextLine[2])
                        .salary(Integer.parseInt(nextLine[3].toString()))
                        .email(nextLine[4])
                        .mobile(nextLine[5])
                        .employeeType(nextLine[6]).build();
                employeeList.add(employee);
            }
        }

        return employeeList;
    }


}
