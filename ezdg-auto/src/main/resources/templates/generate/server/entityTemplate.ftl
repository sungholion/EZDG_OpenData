package ${packageName};

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "${className?lower_case}")
@Getter
@Setter
public class ${className} {
    @Id
    private String id;
    <#list fields as field>
    private ${field.type} ${field.name};
    </#list>
    // Getters and Setters
}