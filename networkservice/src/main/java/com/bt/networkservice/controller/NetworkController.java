package com.bt.networkservice.controller;

import com.bt.networkservice.exception.InvalidFieldException;
import com.bt.networkservice.model.Network;
import com.bt.networkservice.model.NetworkAndUser;
import com.bt.networkservice.model.NetworkUser;
import com.bt.networkservice.repository.NetworkRepository;
import com.bt.networkservice.repository.NetworkUserRepository;
import com.bt.networkservice.service.NetworkService;
import com.bt.networkservice.service.NetworkUserService;
import com.bt.networkservice.utility.Constant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class NetworkController {

    Logger logger = LoggerFactory.getLogger(NetworkController.class);

    @Autowired
    private NetworkService networkService;

    @Autowired
    private NetworkUserService networkUserService;

    @Autowired
    private NetworkRepository networkRepository;

    @Autowired
    private NetworkUserRepository networkUserRepository;

    @PostMapping(Constant.INSERT_DEFAULT_NETWORKS)
    public void insertingValues(){
        logger.info("Inserting values first time");
        Network network = new Network("Copper","150Mbs",250);
        Network network1 = new Network("Fibre","1Gbs",50);

        networkService.saveToNetwork(network);
        networkService.saveToNetwork(network1);

        NetworkUser networkUser = new NetworkUser("Hari","hari@gmail.com");
        NetworkUser networkUser1 = new NetworkUser("Prasanth","prasasnth@gmail.com");

        networkUserService.saveToNetworkUser(networkUser);
        networkUserService.saveToNetworkUser(networkUser1);

    }

    @PostMapping(Constant.CREATE_NETWORK)
    public Network createNetwork(@RequestBody Network network) {
        if(StringUtils.isBlank(network.getName())){
            throw new InvalidFieldException("Name is required");
        }else if(StringUtils.isBlank(network.getBandwidth())){
            throw new InvalidFieldException("BandWidth is required");
        }


        logger.info("Creating Networks");
        Network networkCreating = new Network(
                network.getName(),
                network.getBandwidth(),
                network.getBaseDistance());
        networkService.createNetwork(networkCreating);
        return networkCreating;
    }

    @GetMapping(Constant.GET_ALL_NETWORK)
    public List<Network> getAllNetworks(){
       logger.info("Getting all networks");
       return networkService.getAllNetworks();
    }

    @GetMapping(Constant.BASE_DISTANCE_GT)
    public List<Network> getAllBaseDistanceGreaterThan(@PathVariable int baseDistance){
        logger.info("The total policies are {} ",networkService.getAllNetworks().size());
        List<Network> networkList =
                networkService.findByBaseDistanceGreaterThan(baseDistance);
        return networkList;
    }

    @PutMapping(Constant.UPDATE_NETWORK)
    public String updateNetwork(@RequestBody Network network){
        logger.info("Updating Network");
        Optional<Network> networkOptional = networkService.findById(network.getId());
        if(networkOptional.isPresent()){
            Network networkToUpdate = networkOptional.get();
            networkToUpdate.setName(network.getName());
            networkToUpdate.setBandwidth(network.getBandwidth());
            networkToUpdate.setBaseDistance(network.getBaseDistance());
            networkService.saveToNetwork(networkToUpdate);
            return "Network updated Successfully";
        }
        return "Network not found";
    }

    @DeleteMapping(Constant.DELETE_NETWORK)
    public String deleteNetwork(@PathVariable String name){
        logger.info("Deleting Network");
        Optional<Network> networkDeleteOptional = networkService.findByName(name);
        if(networkDeleteOptional.isPresent()){
            networkService.deleteById(networkDeleteOptional.get().getId());
            return "Policy Deleted Successfully";
        }
        return "Policy not found to be deleted";
    }

    @GetMapping(Constant.GET_NETWORK_AND_USER_DETAILS)
    public NetworkAndUser getNetworkAndUserDetails(){
        NetworkAndUser networkAndUser = new NetworkAndUser();
        networkAndUser.setNetworks(networkRepository.findAll());
        networkAndUser.setUsers(networkUserRepository.findAll());
        return networkAndUser;

    }

}
