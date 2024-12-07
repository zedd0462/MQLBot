package org.mql.mqlbot.config;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import dev.langchain4j.service.AiServices;
import org.mql.mqlbot.services.AiChatService;
import org.mql.mqlbot.services.RAGService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    OpenAiChatModel getOpenAiChatModel(){
        return OpenAiChatModel.builder()
                .apiKey("demo")
                .modelName(OpenAiChatModelName.GPT_4_O_MINI)
                .build();
    }

    @Bean
    AiChatService getDefaultAiChatService(OpenAiChatModel chatModel, RAGService ragService){
        return AiServices.builder(AiChatService.class)
                .chatLanguageModel(chatModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(2))
                .contentRetriever(ragService.getContentRetriever())
                .build();
    }

}
