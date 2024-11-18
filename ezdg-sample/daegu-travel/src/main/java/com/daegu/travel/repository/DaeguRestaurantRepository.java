package com.daegu.travel.repository;

import com.daegu.travel.entity.DaeguRestaurantEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DaeguRestaurantRepository extends MongoRepository<DaeguRestaurantEntity, String> {
    Page<DaeguRestaurantEntity> findByBusinessAddressContaining(String region, Pageable pageable);
}


