package ${packageName};

import common.AbstractAPI;
import java.util.List;

public class ${className}API extends AbstractAPI<${className}Response> {

    public ${className}API() {
    super("${endpoint}");
    }

    <#list requestFields as field>
        /**
        * ${field.description}
        */
        public ${className}API ${field.name}(${field.type} ${field.name}) {
        uriBuilder.setParameter("${field.name}", String.valueOf(${field.name}));
        return this;
        }
    </#list>

    public List<${className}Response> fetch() throws Exception {
        return super.fetch();
        }
        }
