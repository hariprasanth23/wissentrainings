package com.bt.networkservice.service;

import com.bt.networkservice.model.Network;

import java.util.List;
import java.util.Optional;

public interface NetworkService {

    void createNetwork(Network network);
    List<Network> getAllNetworks();
    List<Network> findByBaseDistanceGreaterThan(int baseDistance);
    Optional<Network> findById(int id);
    void saveToNetwork(Network network);
    Optional<Network> findByName(String name);
    void deleteById(int id);

}
