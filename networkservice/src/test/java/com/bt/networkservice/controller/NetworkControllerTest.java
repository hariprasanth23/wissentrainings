package com.bt.networkservice.controller;

import com.bt.networkservice.model.Network;
import com.bt.networkservice.service.NetworkService;
import com.bt.networkservice.utility.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NetworkController.class)
@Slf4j
public class NetworkControllerTest {

    private MockMvc mockMvc;

    @Mock
    private NetworkService networkService;

    @InjectMocks
    private NetworkController networkController;


    Network copperNetwork = new Network("Copper","150Mbs",250);
    Network fibreNetwork = new Network("Fibre","1Gbs",50);

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(networkController).build();
    }


    @Test
    public void getAllNetworkSuccess() throws Exception{
        List<Network> networkList = new ArrayList<>(Arrays.asList(copperNetwork,fibreNetwork));

        Mockito.when(networkService.getAllNetworks()).thenReturn(networkList);

        mockMvc.perform(MockMvcRequestBuilders
                .get(Constant.GET_ALL_NETWORK)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].name",is("Copper")));
    }

}
