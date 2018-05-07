package com.THD.Bot.ChatBot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@Data
public class CustomerBrowseData {
    @Id
    String UUID;

    String svocId;

    String url;

    String productDescription;
}
