package org.mql.mqlbot.dao;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentsDataJSON implements StudentsData {
    @Override
    public List<Document> getStudentsData() {
        return FileSystemDocumentLoader.loadDocuments("src/main/resources/data");
    }
}
