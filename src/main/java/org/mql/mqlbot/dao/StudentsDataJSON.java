package org.mql.mqlbot.dao;

import dev.langchain4j.data.document.Document;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Vector;


@Service
public class StudentsDataJSON implements StudentsData {

    private final ResourceLoader resourceLoader;

    public StudentsDataJSON(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public List<Document> getStudentsData() {
        try {
            Resource resource = resourceLoader.getResource("classpath:data/data.json");
            InputStream inputStream = resource.getInputStream();
            String data = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            List<Document> result = new Vector<>();
            result.add(new Document(data));
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Failed to load the data", e);
        }
    }
}
