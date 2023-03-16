package com.wissen.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Employee {

    @Id
    private int id;
    private String username;
    private Date dateOfBirth;
    private BigDecimal salary;
    private String email;
    private String mobile;
    private String employeeType;

}
