package VilageFcstInfoService;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VilagefcstinfoserviceResponse {
    private Response response;

    // Getters and setters

    @Getter
    @Setter
    public static class Response {
        private Header header;
        private Body body;

        // Getters and setters
    }
    @Getter
    @Setter
    public static class Header {
        private String resultCode;
        private String resultMsg;

        // Getters and setters
    }
    @Getter
    @Setter
    public static class Body {
        private String dataType;
        private Items items;
        private String pageNo;
        private String numOfRows;
        private String totalCount;
    }
    @Getter
    @Setter
    public static class Items {
        private List<Item> item;

        // Getters and setters
    }
    @Getter
    @Setter
    public static class Item {
        private String baseDate;
        private String baseTime;
        private String category;
        private int nx;
        private int ny;
        private String obsrValue;

    }
}