package com.openmind.ezdg.TourStnInfoService1;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class TourStnVilageFcst1Response {

    private Response response;

    @Getter
    @Setter
    public static class Response {
        private Header header;
        private Body body;
    }

    @Getter
    @Setter
    public static class Header {
        private Integer resultCode;
        private String resultMsg;
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
    }

    @Getter
    @Setter
    public static class Item {
        private String tm;
        private String thema;
        private String courseId;
        private String courseAreaId;
        private String courseAreaName;
        private String spotAreaId;
        private String spotAreaName;
        private String courseName;
        private String spotName;
        private String th3;
        private String wd;
        private String ws;
        private String sky;
        private String rhm;
        private String pop;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
            sb.append("Tm: ").append(this.getTm()).append("\n");
            sb.append("Thema: ").append(this.getThema()).append("\n");
            sb.append("CourseId: ").append(this.getCourseId()).append("\n");
            sb.append("CourseAreaId: ").append(this.getCourseAreaId()).append("\n");
            sb.append("CourseAreaName: ").append(this.getCourseAreaName()).append("\n");
            sb.append("SpotAreaId: ").append(this.getSpotAreaId()).append("\n");
            sb.append("SpotAreaName: ").append(this.getSpotAreaName()).append("\n");
            sb.append("CourseName: ").append(this.getCourseName()).append("\n");
            sb.append("SpotName: ").append(this.getSpotName()).append("\n");
            sb.append("Th3: ").append(this.getTh3()).append("\n");
            sb.append("Wd: ").append(this.getWd()).append("\n");
            sb.append("Ws: ").append(this.getWs()).append("\n");
            sb.append("Sky: ").append(this.getSky()).append("\n");
            sb.append("Rhm: ").append(this.getRhm()).append("\n");
            sb.append("Pop: ").append(this.getPop()).append("\n");
            sb.append("-----------------------\n");
            return sb.toString();
        }
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
             return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return super.toString();
        }
    }
}