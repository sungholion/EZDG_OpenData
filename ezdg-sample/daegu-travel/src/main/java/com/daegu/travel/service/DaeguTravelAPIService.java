package com.daegu.travel.service;

import com.openmind.ezdg.daegu_accommodation.DaeguAccommodation;
import com.openmind.ezdg.daegu_accommodation.DaeguAccommodationAPI;
import com.openmind.ezdg.daegu_restaurant.DaeguRestaurant;
import com.openmind.ezdg.daegu_restaurant.DaeguRestaurantAPI;
import com.openmind.ezdg.daegu_tourism.DaeguTourism;
import com.openmind.ezdg.daegu_tourism.DaeguTourismAPI;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class DaeguTravelAPIService {

    public static List<DaeguTourism> getAllDaeguTourismFromAPI() throws URISyntaxException, IOException {
        DaeguTourismAPI api = new DaeguTourismAPI();
        return api.fetch();
    }

    public static List<DaeguAccommodation> getAllDaeguAccommodationFromAPI() throws URISyntaxException, IOException {
        DaeguAccommodationAPI api = new DaeguAccommodationAPI();
        return api.fetch();
    }

    public static List<DaeguRestaurant> getAllDaeguRestaurantFromAPI() throws URISyntaxException, IOException {
        DaeguRestaurantAPI api = new DaeguRestaurantAPI();
        return api.fetch();
    }
}

