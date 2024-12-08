package org.mql.mqlbot.services;

import dev.langchain4j.service.SystemMessage;

public interface AiChatService {
    @SystemMessage("You are a polite assistant")
    String chat(String userMessage);
}
