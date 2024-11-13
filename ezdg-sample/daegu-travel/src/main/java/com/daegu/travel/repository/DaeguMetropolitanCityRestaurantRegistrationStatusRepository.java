package com.daegu.travel.repository;

import com.daegu.travel.entity.DaeguMetropolitanCityRestaurantRegistrationStatusEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DaeguMetropolitanCityRestaurantRegistrationStatusRepository
        extends MongoRepository<DaeguMetropolitanCityRestaurantRegistrationStatusEntity, String> {
}
