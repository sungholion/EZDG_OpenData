package ${packageName};

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Getter
@Setter
public class ${className} {
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
<#if responseFields??>
    <#list responseFields as field>
        <#if field.name != "resultCode" && field.name != "resultMsg" &&
        field.name != "numOfRows" && field.name != "pageNo" &&
        field.name != "totalCount" && field.name != "dataType">
            private String ${field.name};
        </#if>
    </#list>
</#if>

        @Override
        public String toString() {
        StringBuilder sb = new StringBuilder();
    <#if responseFields??>
        <#list responseFields as field>
            <#if field.name != "resultCode" && field.name != "resultMsg" &&
            field.name != "numOfRows" && field.name != "pageNo" &&
            field.name != "totalCount" && field.name != "dataType">
                sb.append("${field.name?cap_first}: ").append(this.get${field.name?cap_first}()).append("\n");
            </#if>
        </#list>
    </#if>
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