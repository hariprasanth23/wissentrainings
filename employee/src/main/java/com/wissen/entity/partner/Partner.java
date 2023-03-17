package com.wissen.entity.partner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
public class Partner {

    @Id
    private int id;
    private String username;

    @Column(name = "date_of_birth")
    private String dateOfBirth;
    private int salary;
    private String email;
    private String mobile;

    @Column(name = "employee_type")
    private String employeeType;

}
