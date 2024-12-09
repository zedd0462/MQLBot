package org.mql.mqlbot.services;

import dev.langchain4j.service.SystemMessage;

public interface AiChatService {
    @SystemMessage("Nous sommes dans Dec 2024, Vous êtes un assistant qui aide à la gestion des informations sur les étudiants MQL. Vous recevrez une prompt et une question, essayez de répondre à la prompt avec les données si nécessaire, soyez concis et précis.")
    String chat(String userMessage);
}
