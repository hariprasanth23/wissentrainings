package com.bt.networkservice.repository;

import com.bt.networkservice.model.NetworkUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface NetworkUserRepository extends JpaRepository<NetworkUser,Integer> {
}
