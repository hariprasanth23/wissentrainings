package com.spring.beanvalidation.controller;

import com.spring.beanvalidation.entity.NetworkRegisteration;
import com.spring.beanvalidation.service.NetworkRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Random;

@RestController
@Slf4j
public class NetworkRegistrationController {

    Logger logger = LoggerFactory.getLogger(NetworkRegistrationController.class);

    @Autowired
    private NetworkRegistrationService networkRegistrationService;

    @PostMapping("/createNetworkRegistration")
    public ResponseEntity<NetworkRegisteration> createNetwork(
           @Valid @RequestBody NetworkRegisteration networkRegisteration){


        NetworkRegisteration networkRegisterationsaving = new NetworkRegisteration(
                networkRegisteration.getName(),
                networkRegisteration.getEmail(),
                networkRegisteration.getNetworkBandWidth(),
                networkRegisteration.getNetworkType());

        networkRegistrationService.saveNetworkRegisterUser(networkRegisterationsaving);

        return new ResponseEntity<NetworkRegisteration>(networkRegisterationsaving, HttpStatus.CREATED);
    }
}
