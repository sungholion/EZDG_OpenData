package com.daegu.travel.service;

import com.openmind.ezdg.daegu_accommodation.DaeguAccommodation;
import com.openmind.ezdg.daegu_accommodation.DaeguAccommodationAPI;
import com.openmind.ezdg.daegu_restaurant.DaeguRestaurant;
import com.openmind.ezdg.daegu_restaurant.DaeguRestaurantAPI;
import com.openmind.ezdg.daegu_tourism.DaeguTourism;
import com.openmind.ezdg.daegu_tourism.DaeguTourismAPI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DaeguTravelAPIService {

    public static List<DaeguTourism> getAllDaeguTourismFromAPI() {
        DaeguTourismAPI api = new DaeguTourismAPI();
        List<DaeguTourism> allData = new ArrayList<>();
        int page = 1;
        List<DaeguTourism> pageData;

        do {
            pageData = api.page(page).fetch();
            allData.addAll(pageData);
            page++;
        } while (!pageData.isEmpty());

        return allData;
    }

    public static List<DaeguAccommodation> getAllDaeguAccommodationFromAPI() {
        DaeguAccommodationAPI api = new DaeguAccommodationAPI();
        List<DaeguAccommodation> allData = new ArrayList<>();
        int page = 1;
        List<DaeguAccommodation> pageData;

        do {
            pageData = api.page(page).fetch();
            allData.addAll(pageData);
            page++;
        } while (!pageData.isEmpty());

        return allData;
    }

    public static List<DaeguRestaurant> getAllDaeguRestaurantFromAPI() {
        DaeguRestaurantAPI api = new DaeguRestaurantAPI();
        String[] regions = {"중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군", "군위군"};

        List<DaeguRestaurant> allData = new ArrayList<>();
        int size = 50; // 페이지당 가져올 개수

        // 각 지역별로 데이터를 조회하여 수집
        for (String region : regions) {
            int page = 1;
            List<DaeguRestaurant> pageData;

            // 페이지별로 데이터를 가져와 추가
            do {
                pageData = api.page(page).perPage(size).businessAddressContaining(region).fetch();
                allData.addAll(pageData);
                page++;
            } while (!pageData.isEmpty());
        }

        return allData;
    }

}

