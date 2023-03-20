package com.wissen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@Builder
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
