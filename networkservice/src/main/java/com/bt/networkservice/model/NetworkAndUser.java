package com.bt.networkservice.model;

import lombok.Data;

import java.util.List;

@Data
public class NetworkAndUser {
    List<Network> networks;
    List<NetworkUser> users;
}
