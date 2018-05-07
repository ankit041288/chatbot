package com.THD.Bot.ChatBot.controller;

import com.THD.Bot.ChatBot.config.MongoRepo;
import com.THD.Bot.ChatBot.model.CustomerBrowseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.UUID;


@RestController
public class CBHController {

    @Autowired
    private MongoRepo repository;

    @PostMapping(value = "/THD/CBH/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void saveCustomerBrowseData(@RequestBody CustomerBrowseData customerBrowseData){
        customerBrowseData.setUUID(UUID.randomUUID().toString());
        repository.save(customerBrowseData);

    }

    @GetMapping(value = "/THD/CBH/{svocId}")
    public List<CustomerBrowseData> getCustomerBrowseData(@PathVariable(value = "svocId") String svocID){
        return repository.findBysvocId(svocID);
    }


}
