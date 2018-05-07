package com.THD.Bot.ChatBot.config;

import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WatsonAssistant {

    @Bean(name = "watsonService")
    public Assistant buildWatsonAssistant() {
        Assistant service = new Assistant("2018-05-05");
        service.setUsernameAndPassword("46902e38-7ced-4699-8d88-2f7f051c97d1", "5N2qv7isA81m");
        return service;
    }


}
