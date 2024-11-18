package ${packageName};

<#--import common.AbstractAPI;-->
import com.openmind.ezdg.common.AbstractAPI;
import java.util.Date;
import java.util.List;
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

public class ${className}API extends AbstractAPI<${className}> {

    public ${className}API() {
        super("/${collectionName}");
    }

    public ${className}API page(int page) {
        return (${className}API) super.page(page);
    }

    public ${className}API perPage(int perPage) {
        return (${className}API) super.perPage(perPage);
    }

<#-- 모든 필드에 대한 빌더 메서드 -->
<#list fields as field>
    public ${className}API ${field.name}(${field.type} ${field.name}) {
        uriBuilder.setParameter("${field.name}", String.valueOf(${field.name}));
        return this;
    }

<#-- 필드 타입에 따른 추가 메서드 -->
<#if field.type == "String">
    public ${className}API ${field.name}Containing(String ${field.name}) {
        uriBuilder.setParameter("${field.name}Containing", ${field.name});
        return this;
    }

<#elseif field.type == "LocalDate" || field.type == "LocalDateTime">
    public ${className}API ${field.name}After(${field.type} ${field.name}After) {
        uriBuilder.setParameter("${field.name}After", ${field.name}After.toString());
        return this;
    }

    public ${className}API ${field.name}Before(${field.type} ${field.name}Before) {
        uriBuilder.setParameter("${field.name}Before", ${field.name}Before.toString());
        return this;
    }

<#elseif field.type == "Long" || field.type == "Double" || field.type == "Integer">
    public ${className}API ${field.name}Lt(${field.type} ${field.name}Lt) {
        uriBuilder.setParameter("${field.name}Lt", String.valueOf(${field.name}Lt));
        return this;
    }

    public ${className}API ${field.name}Lte(${field.type} ${field.name}Lte) {
        uriBuilder.setParameter("${field.name}Lte", String.valueOf(${field.name}Lte));
        return this;
    }

    public ${className}API ${field.name}Gt(${field.type} ${field.name}Gt) {
        uriBuilder.setParameter("${field.name}Gt", String.valueOf(${field.name}Gt));
        return this;
    }

    public ${className}API ${field.name}Gte(${field.type} ${field.name}Gte) {
        uriBuilder.setParameter("${field.name}Gte", String.valueOf(${field.name}Gte));
        return this;
    }
</#if>
</#list>
}