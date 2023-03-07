package com.bt.networkservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Network {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String bandwidth;
    private int baseDistance;


    public Network(String name, String bandwidth, int baseDistance) {
        this.name = name;
        this.bandwidth = bandwidth;
        this.baseDistance = baseDistance;
    }
}
