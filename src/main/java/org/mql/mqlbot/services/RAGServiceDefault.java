package org.mql.mqlbot.services;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.mql.mqlbot.dao.StudentsData;
import org.springframework.stereotype.Service;


@Service
public class RAGServiceDefault implements RAGService {

    private final EmbeddingStore<TextSegment> embeddingStore;

    private RAGServiceDefault(StudentsData studentsData){
        embeddingStore = new InMemoryEmbeddingStore<>();
        EmbeddingStoreIngestor.ingest(studentsData.getStudentsData(), embeddingStore);
    }

    @Override
    public ContentRetriever getContentRetriever() {
        return EmbeddingStoreContentRetriever.from(embeddingStore);
    }
}
