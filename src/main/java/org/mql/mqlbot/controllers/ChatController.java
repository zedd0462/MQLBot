package org.mql.mqlbot.controllers;

import org.mql.mqlbot.dto.ChatRequest;
import org.mql.mqlbot.services.AiChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ChatController {

    AiChatService aiChatService;

    public ChatController(@Autowired AiChatService aiChatService) {
        this.aiChatService = aiChatService;
    }

    @GetMapping("/")
    public String test(){
        return "Hello, the app is running !";
    }

    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody ChatRequest request) {
        return new ResponseEntity<String>(aiChatService.chat(request.getMessage()), HttpStatusCode.valueOf(200));
    }
}
