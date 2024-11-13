package ${packageName};

public class ${className} {
<#list fields as field>
    /**
    * ${field.description}
    */
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