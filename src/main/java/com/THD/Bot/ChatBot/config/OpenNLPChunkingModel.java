package com.THD.Bot.ChatBot.config;

import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import opennlp.tools.parser.ParserModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class OpenNLPChunkingModel {

    @Bean(name = "openNLPModel")
    public ParserModel buildOpenNLPModel() throws IOException {
        InputStream modelInParse = null;
        modelInParse = new FileInputStream("src/main/resources/en-parser-chunking.bin");
        ParserModel model = new ParserModel(modelInParse);
        return model;
    }
}
