package org.mql.mqlbot.dao;

import dev.langchain4j.data.document.Document;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentsData {
    public List<Document> getStudentsData();
}
