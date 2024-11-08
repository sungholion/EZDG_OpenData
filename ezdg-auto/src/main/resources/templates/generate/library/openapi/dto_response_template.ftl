package ${packageName};

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ${className}{
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
<#if responseFields??>
    <#list responseFields as field>
        <#if field.name == "resultCode" || field.name == "resultMsg">
            private ${field.type} ${field.name};
        </#if>
    </#list>
</#if>
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
            <#if field.name != "resultCode" && field.name != "resultMsg">
                private ${field.type} ${field.name};
            </#if>
        </#list>
    </#if>
    }
    }
