package com.openmind.ezdg.file.service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.openmind.ezdg.file.dto.filesave.MongoBsonValueDto;
import com.openmind.ezdg.file.repository.RedisRepository;
import com.openmind.ezdg.file.util.CustomStringUtil;
import com.openmind.ezdg.file.util.KryoSerializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.BsonDocument;
import org.bson.BsonType;
import org.bson.BsonValue;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {

    private final CustomStringUtil customStringUtil;
    private final RedisRepository redisRepository;

    public List<List<MongoBsonValueDto>> getSavedData(String collectionName) {
        List<List<MongoBsonValueDto>> result = new ArrayList<>();
        MongoCollection<Document> collection = redisRepository.getCollection(collectionName);

        // Set the TTL to 12 hours in milliseconds for Redis cache
        long ttlInMillis = Duration.ofHours(12).toMillis();

        // Iterate over all MongoDB documents and cache each individually in Redis
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                String documentId = document.getObjectId("_id").toHexString(); // Use MongoDB's _id as a unique identifier
                String cacheKey = collectionName + ":" + documentId;

                // Try to get the cached data from Redis, or fetch from MongoDB if not cached
                byte[] cacheData = (byte[]) redisRepository.getFromRedis(cacheKey);
                List<MongoBsonValueDto> documentData;

                if (cacheData != null) {
                    log.info("Using cached document from Redis for ID: {}", documentId);
                    documentData = KryoSerializer.deserialize(cacheData);
                } else {
                    // Fetch data from MongoDB and cache in Redis
                    documentData = convertDocumentToDtoList(document);
                    byte[] serializedData = KryoSerializer.serialize(documentData);
                    redisRepository.saveToRedis(cacheKey, serializedData, ttlInMillis, TimeUnit.MILLISECONDS); // Cache with TTL of 12 hours
                }

                result.add(documentData);
            }
        }
        return result;
    }

    // Helper method to convert Document to a list of MongoBsonValueDto
    private List<MongoBsonValueDto> convertDocumentToDtoList(Document document) {
        List<MongoBsonValueDto> documents = new ArrayList<>();
        BsonDocument bsonDoc = document.toBsonDocument(BsonDocument.class, redisRepository.getMongoTemplate().getConverter().getCodecRegistry());

        for (Map.Entry<String, BsonValue> entry : bsonDoc.entrySet()) {
            String fieldName = entry.getKey();
            if (fieldName.equals("_id")) continue; // Exclude the _id field

            BsonValue fieldValue = entry.getValue();
            BsonType fieldType = fieldValue.getBsonType();
            documents.add(new MongoBsonValueDto(fieldName, customStringUtil.bsonValueToStr(fieldValue), fieldType.toString()));
        }
        return documents;
    }
}
