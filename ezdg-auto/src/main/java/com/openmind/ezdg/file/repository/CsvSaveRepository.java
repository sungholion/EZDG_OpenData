package com.openmind.ezdg.file.repository;

import com.mongodb.client.MongoCollection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CsvSaveRepository {

    private final MongoTemplate mongoTemplate;

    public void createCollection(String translatedFileName) {
        mongoTemplate.createCollection(translatedFileName);
    }

    public MongoCollection<Document> getCollection(String collectionName) {
        return mongoTemplate.getCollection(collectionName);
    }

    public void insertDocuments(MongoCollection<Document> collection, List<Document> documents) {
        collection.insertMany(documents);
    }
}
