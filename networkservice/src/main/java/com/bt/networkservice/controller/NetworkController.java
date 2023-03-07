package com.bt.networkservice.controller;

import com.bt.networkservice.model.Network;
import com.bt.networkservice.service.NetworkServiceImpl;
import com.bt.networkservice.utility.Constant;
import lombok.extern.slf4j.Slf4j;
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
    private NetworkServiceImpl networkService;

    @PostMapping(Constant.INSERT_DEFAULT_NETWORKS)
    public void insertingValues(){
        logger.info("Inserting values first time");
        Network network = new Network("Copper","150Mbs",250);
        Network network1 = new Network("Fibre","1Gbs",50);

        networkService.saveToNetwork(network);
        networkService.saveToNetwork(network1);

    }

    @PostMapping(Constant.CREATE_NETWORK)
    public void createNetwork(@RequestBody Network network){
        logger.info("Creating Networks");
        Network networkCreating = new Network(
                network.getName(),
                network.getBandwidth(),
                network.getBaseDistance());
        networkService.createNetwork(networkCreating);
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


}
