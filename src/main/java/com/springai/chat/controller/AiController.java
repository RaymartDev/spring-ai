package com.springai.chat.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final ChatClient chatClient;

    // Accept both profession and question in a DTO (cleaner than raw Map)
    public static class AdviceRequest {
        private String profession;
        private String question;

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }
    }

    public AiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
    @PostMapping("/sql")
    public String textToSql(@RequestBody AdviceRequest request) {
        String profession = request.getProfession();
        String question = request.getQuestion();

        return chatClient.prompt()
                .system("You are a professional " + profession + " that can give advice.")
                .user("Give advice on: " + question)
                .call()
                .content();

    }
}
