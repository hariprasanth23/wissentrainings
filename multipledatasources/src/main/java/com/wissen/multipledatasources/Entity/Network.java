package com.wissen.multipledatasources.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@NoArgsConstructor
@Data
public class Network {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int bandWidth;
    private int baseDistance;

    public Network(String name, int bandWidth, int baseDistance) {
        this.name = name;
        this.bandWidth = bandWidth;
        this.baseDistance = baseDistance;
    }
}
