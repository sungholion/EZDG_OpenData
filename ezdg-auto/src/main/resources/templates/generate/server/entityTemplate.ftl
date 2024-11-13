package ${packageName};

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

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