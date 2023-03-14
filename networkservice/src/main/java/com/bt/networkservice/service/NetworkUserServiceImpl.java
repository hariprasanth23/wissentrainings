package com.bt.networkservice.service;

import com.bt.networkservice.model.NetworkUser;
import com.bt.networkservice.repository.NetworkUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NetworkUserServiceImpl implements NetworkUserService{

    Logger logger = LoggerFactory.getLogger(NetworkUserServiceImpl.class);

    @Autowired
    private NetworkUserRepository networkUserRepository;

    public void saveToNetworkUser(NetworkUser networkUser) {
        logger.info("Saving into Network User");
        networkUserRepository.save(networkUser);
    }


}
