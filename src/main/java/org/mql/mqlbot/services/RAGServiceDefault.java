package org.mql.mqlbot.services;


import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.mql.mqlbot.dao.StudentsData;
import org.springframework.stereotype.Service;
import dev.langchain4j.model.embedding.onnx.allminilml6v2.*;


@Service
public class RAGServiceDefault implements RAGService {

    private final EmbeddingStore<TextSegment> embeddingStore;
    private final EmbeddingStoreIngestor ingestor;

    private RAGServiceDefault(StudentsData studentsData, JSONDocumentSplitter splitter){
        embeddingStore = new InMemoryEmbeddingStore<>();
        ingestor = EmbeddingStoreIngestor.builder()
                .embeddingStore(embeddingStore)
                .embeddingModel(new AllMiniLmL6V2EmbeddingModel())
                .documentSplitter(splitter)
                .build();
        ingestor.ingest(studentsData.getStudentsData());
    }

    @Override
    public ContentRetriever getContentRetriever() {
        return EmbeddingStoreContentRetriever.from(embeddingStore);
    }
}
