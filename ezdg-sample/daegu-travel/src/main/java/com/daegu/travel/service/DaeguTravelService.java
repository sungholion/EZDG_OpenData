package com.daegu.travel.service;

import com.daegu.travel.dto.DaeguTravelDto;
import com.daegu.travel.entity.DaeguTravelEntity;
import com.daegu.travel.repository.DaeguTravelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DaeguTravelService {

    private static DaeguTravelRepository daeguTravelRepository = null;

    public DaeguTravelService(DaeguTravelRepository daeguTravelRepository) {
        this.daeguTravelRepository = daeguTravelRepository;
    }

    public static List<DaeguTravelDto> getAllDaeguTravel() {
        List<DaeguTravelEntity> entities = daeguTravelRepository.findAll();
        return entities.stream()
                .map(entity -> new DaeguTravelDto(
                        entity.getId(),
                        entity.getType(),
                        entity.getTitle(),
                        entity.getCourseNum(),
                        entity.getTopic(),
                        entity.getTopicDescription(),
                        entity.getRegion(),
                        entity.getSpot(),
                        entity.getCourseDescription(),
                        entity.getAddress(),
                        entity.getPhone(),
                        entity.getHomepage()))
                .collect(Collectors.toList());
    }
}
