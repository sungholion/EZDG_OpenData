package ${packageName};

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

public class ${className} {

<#list fields as field>
    private ${field.type} ${field.name};
</#list>

    // Getters and Setters
<#list fields as field>
    public ${field.type} get${field.name?cap_first}() {
        return ${field.name};
    }

    public void set${field.name?cap_first}(${field.type} ${field.name}) {
        this.${field.name} = ${field.name};
    }

</#list>
}
