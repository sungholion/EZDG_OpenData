package ${packageName};

import ${packageName}.${className}Service;
import ${packageName}.${className};
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
@RequestMapping("/${collectionName}")
public class ${className}Controller {

    private final ${className}Service service;

    @GetMapping("")
    public List<${className}> search (
    <#list fields as field>
            @RequestParam(required = false) ${field.type} ${field.name},
        <#if field.type == "String">
            @RequestParam(required = false) ${field.type} ${field.name}Containing,
        </#if>
        <#if field.type == "Date">
            @RequestParam(required = false) ${field.type} ${field.name}After,
            @RequestParam(required = false) ${field.type} ${field.name}Before,
        </#if>
        <#if field.type == "Long" || field.type == "Double" || field.type == "Integer">
            @RequestParam(required = false) ${field.type} ${field.name}Lt,
            @RequestParam(required = false) ${field.type} ${field.name}Lte,
            @RequestParam(required = false) ${field.type} ${field.name}Gt,
            @RequestParam(required = false) ${field.type} ${field.name}Gte,
        </#if>
    </#list>
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int perPage) {

        Map <String, Object> params = new HashMap<>();

    <#list fields as field>
        params.put("${field.name}", ${field.name});
        <#if field.type == "String">
        params.put("${field.name}Containing", ${field.name}Containing);
        </#if>
        <#if field.type == "Date">
        params.put("${field.name}After", ${field.name}After);
        params.put("${field.name}Before", ${field.name}Before);
        </#if>
        <#if field.type == "Long" || field.type == "Double" || field.type == "Integer">
        params.put("${field.name}Lt", ${field.name}Lt);
        params.put("${field.name}Lte", ${field.name}Lte);
        params.put("${field.name}Gt", ${field.name}Gt);
        params.put("${field.name}Gte", ${field.name}Gte);
        </#if>
    </#list>

        return service.search(params, page, perPage);
    }
}
