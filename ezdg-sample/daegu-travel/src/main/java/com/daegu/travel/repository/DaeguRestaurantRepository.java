package com.daegu.travel.repository;

import com.daegu.travel.entity.DaeguRestaurantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DaeguRestaurantRepository extends MongoRepository<DaeguRestaurantEntity, String> {
    Page<DaeguRestaurantEntity> findByBusinessAddressContaining(String region, Pageable pageable);

    @Aggregation(pipeline = {
            "{ '$match': { 'businessAddress': { $regex: ?0 } } }",
            "{ '$limit': ?1 }"
    })
    List<DaeguRestaurantEntity> findTopByRegion(String region, int limit);
}


