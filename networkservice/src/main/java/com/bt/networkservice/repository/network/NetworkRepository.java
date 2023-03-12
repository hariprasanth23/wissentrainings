package com.bt.networkservice.repository.network;

import com.bt.networkservice.model.Network;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface NetworkRepository extends JpaRepository<Network,Integer> {
    List<Network> findByBaseDistanceGreaterThan(int baseDistance);
    Optional<Network> findByName(String name);
    List<Network> findAll();
}
