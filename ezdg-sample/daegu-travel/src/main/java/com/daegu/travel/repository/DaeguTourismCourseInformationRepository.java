package com.daegu.travel.repository;

import com.daegu.travel.entity.DaeguTourismCourseInformationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

//
public interface DaeguTourismCourseInformationRepository extends MongoRepository<DaeguTourismCourseInformationEntity, String> {
}
