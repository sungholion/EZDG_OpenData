package com.openmind.ezdg.file.repository;

import com.mongodb.client.MongoCollection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RedisRepository {

    private final MongoTemplate mongoTemplate;
    private final RedisTemplate<String, Object> redisTemplate;


    public MongoCollection<Document> getCollection(String collectionName) {
        return mongoTemplate.getCollection(collectionName);
    }

    // Redis operations
    public void saveToRedis(String key, Object data, long duration, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, data, duration, unit);  // Save data with expiration
    }

    public Object getFromRedis(String key) {
        return redisTemplate.opsForValue().get(key);  // Retrieve data by key
    }

    // Example of caching a MongoDB query result in Redis
    public List<Document> getCachedCollectionData(String collectionName) {
        String cacheKey = "collection::" + collectionName;

        // Try to retrieve from Redis
        List<Document> cachedData = (List<Document>) getFromRedis(cacheKey);
        if (cachedData != null) {
            log.info("Returning data from Redis cache for collection: {}", collectionName);
            return cachedData;
        }

        // Fetch from MongoDB and cache it in Redis if not found
        MongoCollection<Document> collection = getCollection(collectionName);
        List<Document> data = collection.find().into(new ArrayList<>());  // Retrieve all documents
        saveToRedis(cacheKey, data, 12, TimeUnit.HOURS);  // Cache with 12-hour TTL
        return data;
    }
}
