package ${packageName};

import com.openmind.ezdg.generate.library.openapi.AbstractAPI;
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

    // fetch 메서드는 예외를 던지지 않도록 수정
    public List<${className}Response> fetch() {
        return super.fetch();
        }
        }
