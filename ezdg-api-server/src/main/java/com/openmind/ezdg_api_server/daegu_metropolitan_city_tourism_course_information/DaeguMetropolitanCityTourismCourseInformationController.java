package com.openmind.ezdg_api_server.daegu_metropolitan_city_tourism_course_information;

import com.openmind.ezdg_api_server.daegu_metropolitan_city_tourism_course_information.DaeguMetropolitanCityTourismCourseInformationService;
import com.openmind.ezdg_api_server.daegu_metropolitan_city_tourism_course_information.DaeguMetropolitanCityTourismCourseInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("daegu_metropolitan_city_tourism_course_information")
@RequiredArgsConstructor
public class DaeguMetropolitanCityTourismCourseInformationController {
private final DaeguMetropolitanCityTourismCourseInformationService service;

@GetMapping("")
public List<DaeguMetropolitanCityTourismCourseInformation> search(
    @RequestParam(required = false) String classification,
        @RequestParam(required = false) String classificationContaining,
    @RequestParam(required = false) String courseTitle,
        @RequestParam(required = false) String courseTitleContaining,
    @RequestParam(required = false) Long courseNumber,
        @RequestParam(required = false) Long courseNumberLt,
        @RequestParam(required = false) Long courseNumberLte,
        @RequestParam(required = false) Long courseNumberGt,
        @RequestParam(required = false) Long courseNumberGte,
    @RequestParam(required = false) String courseTopic,
        @RequestParam(required = false) String courseTopicContaining,
    @RequestParam(required = false) String courseTopicDescription,
        @RequestParam(required = false) String courseTopicDescriptionContaining,
    @RequestParam(required = false) String region,
        @RequestParam(required = false) String regionContaining,
    @RequestParam(required = false) String touristDestination,
        @RequestParam(required = false) String touristDestinationContaining,
    @RequestParam(required = false) String courseDescription,
        @RequestParam(required = false) String courseDescriptionContaining,
    @RequestParam(required = false) String address,
        @RequestParam(required = false) String addressContaining,
    @RequestParam(required = false) String phoneNumber,
        @RequestParam(required = false) String phoneNumberContaining,
    @RequestParam(required = false) String homepage,
        @RequestParam(required = false) String homepageContaining,
@RequestParam(required = false, defaultValue = "0") int page,
@RequestParam(required = false, defaultValue = "10") int perPage
) {
Map
<String, Object> params = new HashMap<>();
    params.put("classification", classification);
        params.put("classificationContaining", classificationContaining);
    params.put("courseTitle", courseTitle);
        params.put("courseTitleContaining", courseTitleContaining);
    params.put("courseNumber", courseNumber);
        params.put("courseNumberLt", courseNumberLt);
        params.put("courseNumberLte", courseNumberLte);
        params.put("courseNumberGt", courseNumberGt);
        params.put("courseNumberGte", courseNumberGte);
    params.put("courseTopic", courseTopic);
        params.put("courseTopicContaining", courseTopicContaining);
    params.put("courseTopicDescription", courseTopicDescription);
        params.put("courseTopicDescriptionContaining", courseTopicDescriptionContaining);
    params.put("region", region);
        params.put("regionContaining", regionContaining);
    params.put("touristDestination", touristDestination);
        params.put("touristDestinationContaining", touristDestinationContaining);
    params.put("courseDescription", courseDescription);
        params.put("courseDescriptionContaining", courseDescriptionContaining);
    params.put("address", address);
        params.put("addressContaining", addressContaining);
    params.put("phoneNumber", phoneNumber);
        params.put("phoneNumberContaining", phoneNumberContaining);
    params.put("homepage", homepage);
        params.put("homepageContaining", homepageContaining);

return service.search(params, page, perPage);
}
}
