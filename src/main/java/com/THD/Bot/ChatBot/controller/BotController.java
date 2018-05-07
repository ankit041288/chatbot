package com.THD.Bot.ChatBot.controller;


import com.THD.Bot.ChatBot.config.NLPNounExtraction;
import com.THD.Bot.ChatBot.model.ChatRequest;
import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import com.ibm.watson.developer_cloud.assistant.v1.model.InputData;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class BotController {

    @Qualifier("watsonService")
    @Autowired
    Assistant service;


    @Autowired
    NLPNounExtraction nlpNounExtraction;

    String workspaceId = "73debc57-da53-4e9b-ba11-e2279d02f02b";


    @PostMapping(value = "/THD/chatBot/", produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageResponse getReponseToText(@RequestBody ChatRequest chatRequest) throws IOException {

        InputData input = new InputData.Builder(chatRequest.getText()).build();

        MessageOptions options = new MessageOptions.Builder(workspaceId)
                .input(input)
                .build();

        MessageResponse response = service.message(options).execute();


//       nlpNounExtraction.getNounFromChat(chatRequest.getText());

        return response;
    }


}
