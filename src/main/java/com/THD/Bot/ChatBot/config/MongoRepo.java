package com.THD.Bot.ChatBot.config;

import com.THD.Bot.ChatBot.model.CustomerBrowseData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoRepo extends MongoRepository<CustomerBrowseData, String> {
    public List<CustomerBrowseData> findBysvocId(String svocID);

}