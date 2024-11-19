package com.daegu.travel.repository;

import com.daegu.travel.entity.DaeguAccommodationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DaeguAccommodationRepository extends MongoRepository<DaeguAccommodationEntity, String> {
}
