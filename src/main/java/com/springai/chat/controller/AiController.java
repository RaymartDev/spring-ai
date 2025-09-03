package com.springai.chat.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final ChatClient chatClient;

    public AiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
    @PostMapping("/sql")
    public String textToSql(@RequestBody String question) {

        return chatClient.prompt()
                .system("You are a professional PostgresSQL developer / analyst     that can give advice")
                .user("Give advice how to obtain this: " + question)
                .call()
                .content();

    }
}
