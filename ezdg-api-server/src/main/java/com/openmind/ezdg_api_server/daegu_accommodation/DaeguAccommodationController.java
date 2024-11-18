package com.openmind.ezdg_api_server.daegu_accommodation;

import com.openmind.ezdg_api_server.daegu_accommodation.DaeguAccommodationService;
import com.openmind.ezdg_api_server.daegu_accommodation.DaeguAccommodation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/daegu_accommodation")
public class DaeguAccommodationController {

    private final DaeguAccommodationService service;

    @GetMapping("")
    public List<DaeguAccommodation> search (
            @RequestParam(required = false) Long number,
        <            @RequestParam(required = false) Long numberLt,
            @RequestParam(required = false) Long numberLte,
            @RequestParam(required = false) Long numberGt,
            @RequestParam(required = false) Long numberGte,
            @RequestParam(required = false) String region,
            @RequestParam(required = false) String regionContaining,
        <            @RequestParam(required = false) String industryClassification,
            @RequestParam(required = false) String industryClassificationContaining,
        <            @RequestParam(required = false) String hotelName,
            @RequestParam(required = false) String hotelNameContaining,
        <            @RequestParam(required = false) Long guestMistakeStard,
        <            @RequestParam(required = false) Long guestMistakeStardLt,
            @RequestParam(required = false) Long guestMistakeStardLte,
            @RequestParam(required = false) Long guestMistakeStardGt,
            @RequestParam(required = false) Long guestMistakeStardGte,
            @RequestParam(required = false) Long guestMistakeDeluxe,
        <            @RequestParam(required = false) Long guestMistakeDeluxeLt,
            @RequestParam(required = false) Long guestMistakeDeluxeLte,
            @RequestParam(required = false) Long guestMistakeDeluxeGt,
            @RequestParam(required = false) Long guestMistakeDeluxeGte,
            @RequestParam(required = false) Long guestMistakeSuite,
        <            @RequestParam(required = false) Long guestMistakeSuiteLt,
            @RequestParam(required = false) Long guestMistakeSuiteLte,
            @RequestParam(required = false) Long guestMistakeSuiteGt,
            @RequestParam(required = false) Long guestMistakeSuiteGte,
            @RequestParam(required = false) Long guestMistakeOneRoom,
        <            @RequestParam(required = false) Long guestMistakeOneRoomLt,
            @RequestParam(required = false) Long guestMistakeOneRoomLte,
            @RequestParam(required = false) Long guestMistakeOneRoomGt,
            @RequestParam(required = false) Long guestMistakeOneRoomGte,
            @RequestParam(required = false) String guestMistakeOther,
            @RequestParam(required = false) String guestMistakeOtherContaining,
        <            @RequestParam(required = false) Long guestMistakeCount,
        <            @RequestParam(required = false) Long guestMistakeCountLt,
            @RequestParam(required = false) Long guestMistakeCountLte,
            @RequestParam(required = false) Long guestMistakeCountGt,
            @RequestParam(required = false) Long guestMistakeCountGte,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String locationContaining,
        <            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String phoneNumberContaining,
        <            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

        params.put("number", number);
        params.put("numberLt", numberLt);
        params.put("numberLte", numberLte);
        params.put("numberGt", numberGt);
        params.put("numberGte", numberGte);
        params.put("region", region);
        params.put("regionContaining", regionContaining);
        params.put("industryClassification", industryClassification);
        params.put("industryClassificationContaining", industryClassificationContaining);
        params.put("hotelName", hotelName);
        params.put("hotelNameContaining", hotelNameContaining);
        params.put("guestMistakeStard", guestMistakeStard);
        params.put("guestMistakeStardLt", guestMistakeStardLt);
        params.put("guestMistakeStardLte", guestMistakeStardLte);
        params.put("guestMistakeStardGt", guestMistakeStardGt);
        params.put("guestMistakeStardGte", guestMistakeStardGte);
        params.put("guestMistakeDeluxe", guestMistakeDeluxe);
        params.put("guestMistakeDeluxeLt", guestMistakeDeluxeLt);
        params.put("guestMistakeDeluxeLte", guestMistakeDeluxeLte);
        params.put("guestMistakeDeluxeGt", guestMistakeDeluxeGt);
        params.put("guestMistakeDeluxeGte", guestMistakeDeluxeGte);
        params.put("guestMistakeSuite", guestMistakeSuite);
        params.put("guestMistakeSuiteLt", guestMistakeSuiteLt);
        params.put("guestMistakeSuiteLte", guestMistakeSuiteLte);
        params.put("guestMistakeSuiteGt", guestMistakeSuiteGt);
        params.put("guestMistakeSuiteGte", guestMistakeSuiteGte);
        params.put("guestMistakeOneRoom", guestMistakeOneRoom);
        params.put("guestMistakeOneRoomLt", guestMistakeOneRoomLt);
        params.put("guestMistakeOneRoomLte", guestMistakeOneRoomLte);
        params.put("guestMistakeOneRoomGt", guestMistakeOneRoomGt);
        params.put("guestMistakeOneRoomGte", guestMistakeOneRoomGte);
        params.put("guestMistakeOther", guestMistakeOther);
        params.put("guestMistakeOtherContaining", guestMistakeOtherContaining);
        params.put("guestMistakeCount", guestMistakeCount);
        params.put("guestMistakeCountLt", guestMistakeCountLt);
        params.put("guestMistakeCountLte", guestMistakeCountLte);
        params.put("guestMistakeCountGt", guestMistakeCountGt);
        params.put("guestMistakeCountGte", guestMistakeCountGte);
        params.put("location", location);
        params.put("locationContaining", locationContaining);
        params.put("phoneNumber", phoneNumber);
        params.put("phoneNumberContaining", phoneNumberContaining);

        return service.search(params, page, perPage);
    }
}
