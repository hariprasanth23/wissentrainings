package com.wissen.controller;

import com.wissen.entity.Employee;
import com.wissen.entity.Partner;
import com.wissen.entity.builder.Customer;
import com.wissen.entity.builder.Person;
import com.wissen.entity.builder.User;
import com.wissen.service.EmployeeService;
import com.wissen.utility.Constant;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(Constant.EMPLOYEE_BULK_UPLOAD)
    public String uploadBulkEmployee(){

        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = Employee.builder()
                .id(1).username("user1").dateOfBirth("DOB").salary(1000)
                .email("Email1").mobile("mobile1").employeeType("HR").build();

        Employee employee2 = new Employee(2,"user2","DOB",1000,"email2","mobile2","Technology");
        Employee employee3 = new Employee(3,"user3","DOB",1000,"email3","mobile3","Partners");
        Employee employee4 = new Employee(4,"user4","DOB",1000,"email4","mobile4","Partners");

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);

        logger.info("Logging of "+ employeeList);
        employeeService.bulkUpload(employeeList);
        return "Successfully Uploaded Bulk Data";
    }

    @GetMapping("/getAllPartners")
    public List<Partner> getAllPartners(){
        logger.info(" Getting All Partner Details ");
        return employeeService.getAllPartner();
    }

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee(){
        logger.info(" Getting all Employee Details ");
        return employeeService.getAllEmployee();
    }

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/savePartner")
    public Partner savePartner(@RequestBody Partner partner){
        return employeeService.savePartner(partner);
    }


    @GetMapping("/userBuilderPattern")
    public String userBuilderPattern(){
        logger.info(" user builder pattern class level");
        User user1 = User.builder()
                .name("Hari")
                .age(25)
                .build();

        User user2 = User.builder().age(25).build();

        User user3 = User.builder().build();

        logger.info("user1--> " + user1.getName() + " "+ user1.getAge());
        logger.info("user2--> "+user2.getName() + " "+ user2.getAge());
        logger.info("user3--> "+user3.getName() + " "+ user3.getAge());

        return "userBuilderPattern";
    }

    @GetMapping("/personBuilderPattern")
    public String personBuilderPattern(){
        logger.info(" person builder pattern constructor level");
        Person person = Person.builder()
                .age(30)
                .name("Hari").build();

        logger.info("person--> " + person.getName() + " "+ person.getAge()+" "+person.getRole() + " " + person.isActive());

        return "patternBuilderPattern";
    }

    @GetMapping("/customerBuilderPattern")
    public String customerBuilderPattern(){
        logger.info(" custom builder pattern method level");

        Customer customer = Customer.builder()
                        .name("Hari customer")
                         .age(40)
                         .build();
                logger.info("customer--> " + customer.getName() + " "+ customer.getAge()+" "+customer.getCity() + " " + customer.isActive());

        return "customerBuilderPattern";
    }

}
