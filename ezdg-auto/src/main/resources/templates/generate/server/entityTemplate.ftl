package ${packageName};

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
<#assign hasLocalDate = false>
<#assign hasLocalDateTime = false>
<#list fields as field>
    <#if field.type == "LocalDate">
        <#assign hasLocalDate = true>
    </#if>
    <#if field.type == "LocalDateTime">
        <#assign hasLocalDateTime = true>
    </#if>
</#list>
<#if hasLocalDate>
import java.time.LocalDate;
</#if>
<#if hasLocalDateTime>
import java.time.LocalDateTime;
</#if>


@Getter
@Setter
@Document(collection = "${collectionName}")
public class ${className} {
    @Id
    private String id;
<#list fields as field>
    private ${field.type} ${field.name};
</#list>
}