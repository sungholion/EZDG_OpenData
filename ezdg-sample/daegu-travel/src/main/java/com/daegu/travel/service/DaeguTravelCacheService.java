package com.daegu.travel.service;

import com.daegu.travel.dto.DaeguTourismDto;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DaeguTravelCacheService {
    private final CacheManager cacheManager;

    public DaeguTravelCacheService(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

//    @Cacheable(value = "daeguTourismCache")
//    public List<DaeguTourismDto> getCachedTourismData(Pageable pageable) {
//        return getAllDaeguTourismFromDB(pageable);
//    }
}
