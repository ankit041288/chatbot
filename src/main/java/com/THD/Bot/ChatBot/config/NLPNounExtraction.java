package com.THD.Bot.ChatBot.config;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NLPNounExtraction {
    static Set<String> nounPhrases = new HashSet<>();

    @Qualifier("openNLPModel")
    @Autowired
    ParserModel model;

    public Set<String> getNounFromChat(String chatText) throws IOException {


        //create parse tree
        Parser parser = ParserFactory.create(model);
        Parse topParses[] = ParserTool.parseLine(chatText, parser, 1);

        //call subroutine to extract noun phrases
        for (Parse p : topParses)
            getNounPhrases(p);

        return nounPhrases;
    }
    private  void getNounPhrases(Parse p) {

        if (p.getType().equals("NP")) { //NP=noun phrase
            nounPhrases.add(p.getText());
        }
        for (Parse child : p.getChildren())
            getNounPhrases(child);
    }
}
