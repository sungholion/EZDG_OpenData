package com.daegu.travel.repository;

import com.daegu.travel.entity.DaeguTravelEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaeguTravelRepository extends MongoRepository<DaeguTravelEntity, String> {
}
