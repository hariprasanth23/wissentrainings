package com.wissen.multipledatasources.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@NoArgsConstructor
@Data
public class NetworkUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private int email;
    private int networkType;

    public NetworkUser(String username, int email, int networkType) {
        this.username = username;
        this.email = email;
        this.networkType = networkType;
    }
}
