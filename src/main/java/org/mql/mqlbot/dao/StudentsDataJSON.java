package org.mql.mqlbot.dao;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


@Service
public class StudentsDataJSON implements StudentsData {
    @Override
    public List<Document> getStudentsData() {
        try {
            Path directoryPath = new ClassPathResource("data").getFile().toPath();
            return FileSystemDocumentLoader.loadDocuments(directoryPath);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load data directory", e);
        }

    }
}
