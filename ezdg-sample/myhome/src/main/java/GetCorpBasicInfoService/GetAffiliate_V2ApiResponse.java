package GetCorpBasicInfoService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAffiliate_V2ApiResponse {
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
            private String basDt;
            private String crno;
            private String afilCmpyNm;
            private String afilCmpyCrno;
            private String lstgYn;

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
                sb.append("BasDt: ").append(this.getBasDt()).append("\n");
                sb.append("Crno: ").append(this.getCrno()).append("\n");
                sb.append("AfilCmpyNm: ").append(this.getAfilCmpyNm()).append("\n");
                sb.append("AfilCmpyCrno: ").append(this.getAfilCmpyCrno()).append("\n");
                sb.append("LstgYn: ").append(this.getLstgYn()).append("\n");
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