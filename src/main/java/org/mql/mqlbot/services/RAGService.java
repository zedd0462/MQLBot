package org.mql.mqlbot.services;

import dev.langchain4j.rag.content.retriever.ContentRetriever;

public interface RAGService {
    ContentRetriever getContentRetriever();
}
