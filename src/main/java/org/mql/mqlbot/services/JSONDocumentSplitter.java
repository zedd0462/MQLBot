package org.mql.mqlbot.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentSplitter;
import dev.langchain4j.data.segment.TextSegment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Vector;

@Service
public class JSONDocumentSplitter implements DocumentSplitter {

    private final ObjectMapper objectMapper;

    public JSONDocumentSplitter() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public List<TextSegment> split(Document document) {
        List<TextSegment> segments = new Vector<>();
        try {
            JsonNode rootNode = objectMapper.readTree(document.text());
            for(JsonNode node : rootNode){
                String segmentText =  objectMapper.writeValueAsString(node);
                segments.add(TextSegment.from(segmentText));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to split the file.", e);
        }
        return segments;
    }

    @Override
    public List<TextSegment> splitAll(List<Document> documents) {
        return DocumentSplitter.super.splitAll(documents);
    }
}
