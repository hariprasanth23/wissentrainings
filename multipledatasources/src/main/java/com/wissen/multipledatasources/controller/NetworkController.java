package com.wissen.multipledatasources.controller;

import com.wissen.multipledatasources.Entity.Network;
import com.wissen.multipledatasources.datasourceconfiguration.NetworkDatasourceConfiguration;
import com.wissen.multipledatasources.jpaconfiguration.NetworkJpaConfiguration;
import com.wissen.multipledatasources.repository.NetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class NetworkController {

//    @Autowired
//    NetworkRepository networkRepository;
//
//    @GetMapping("/getAllNetwork")
//    public Iterable<Network> getAllNetwork(){
//        return networkRepository.findAll();
//    }

}
