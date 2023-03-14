package com.spring.beanvalidation.repository;

import com.spring.beanvalidation.entity.NetworkRegisteration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NetworkRegistrationRepository extends JpaRepository<NetworkRegisteration,Integer> {
}
