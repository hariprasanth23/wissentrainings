package com.spring.beanvalidation.service;

import com.spring.beanvalidation.entity.NetworkRegisteration;
import com.spring.beanvalidation.repository.NetworkRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworkRegistrationService {

    @Autowired
    private NetworkRegistrationRepository networkRegistrationRepository;

    public NetworkRegisteration saveNetworkRegisterUser(NetworkRegisteration networkRegisteration){
        return networkRegistrationRepository.save(networkRegisteration);
    }

}
