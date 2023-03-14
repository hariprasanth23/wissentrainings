package com.spring.beanvalidation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class NetworkRegisteration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Size(min = 4,message = " invalid name length ")
    private String name;

    @NotEmpty
    @Email
    private String email;

    @Max(value = 1000)
    private int networkBandWidth;

    private String networkType;

    public NetworkRegisteration(String name, String email, int networkBandWidth, String networkType) {
        this.name = name;
        this.email = email;
        this.networkBandWidth = networkBandWidth;
        this.networkType = networkType;
    }
}
