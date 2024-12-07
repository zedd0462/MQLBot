package org.mql.mqlbot.services;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;
import org.springframework.stereotype.Service;

@Service
public interface AiChatService {
    @SystemMessage("You are a polite assistant")
    String chat(String userMessage);
}
