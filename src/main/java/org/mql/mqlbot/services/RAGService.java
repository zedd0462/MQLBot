package org.mql.mqlbot.services;

import dev.langchain4j.rag.content.retriever.ContentRetriever;
import org.springframework.stereotype.Service;

public interface RAGService {
    ContentRetriever getContentRetriever();
}
