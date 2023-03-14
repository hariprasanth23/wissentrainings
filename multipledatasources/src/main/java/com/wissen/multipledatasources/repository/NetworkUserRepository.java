package com.wissen.multipledatasources.repository;

import com.wissen.multipledatasources.Entity.NetworkUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NetworkUserRepository extends JpaRepository<NetworkUser,Integer> {
}
