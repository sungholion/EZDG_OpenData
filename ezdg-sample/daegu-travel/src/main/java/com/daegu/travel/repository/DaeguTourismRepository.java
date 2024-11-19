package com.daegu.travel.repository;

import com.daegu.travel.entity.DaeguTourismEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DaeguTourismRepository extends MongoRepository<DaeguTourismEntity, String> {
}
