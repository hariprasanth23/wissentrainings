package com.bt.networkservice.service;

import com.bt.networkservice.model.Network;
import com.bt.networkservice.repository.network.NetworkRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class NetworkServiceImpl implements NetworkService{

    Logger logger = LoggerFactory.getLogger(NetworkServiceImpl.class);

    @Autowired
    private NetworkRepository networkRepository;

    public void createNetwork(Network network){
        networkRepository.save(network);
        logger.info(" network {} is saved ", network.getId());
    }

    public List<Network> getAllNetworks() {
        return networkRepository.findAll();
    }


    public List<Network> findByBaseDistanceGreaterThan(int baseDistance) {
        return networkRepository.findByBaseDistanceGreaterThan(baseDistance);
    }

    public Optional<Network> findById(int id) {
        return networkRepository.findById(id);
    }

    public void saveToNetwork(Network network) {
        networkRepository.save(network);
    }

    public Optional<Network> findByName(String name) {
        return networkRepository.findByName(name);
    }

    public void deleteById(int id){
        networkRepository.deleteById(id);
    }


}
