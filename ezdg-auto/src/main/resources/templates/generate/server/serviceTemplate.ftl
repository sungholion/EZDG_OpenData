package ${packageName};

import ${packageName}.${className};
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ${className}Service {

    private final MongoTemplate mongoTemplate;

    public List<${className}> search(Map<String, Object> params, int page, int perPage) {
        Query query = new Query();

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if (value != null) {
                if (key.endsWith("Containing")) {
                    String field = key.replace("Containing", "");
                    query.addCriteria(Criteria.where(field).regex(".*" + value + ".*", "i"));
                } else if (key.endsWith("After")) {
                    String field = key.replace("After", "");
                    query.addCriteria(Criteria.where(field).gte(value));
                } else if (key.endsWith("Before")) {
                    String field = key.replace("Before", "");
                    query.addCriteria(Criteria.where(field).lte(value));
                } else if (key.endsWith("Lt")) {
                    String field = key.replace("Lt", "");
                    query.addCriteria(Criteria.where(field).lt(value));
                } else if (key.endsWith("Lte")) {
                    String field = key.replace("Lte", "");
                    query.addCriteria(Criteria.where(field).lte(value));
                } else if (key.endsWith("Gt")) {
                    String field = key.replace("Gt", "");
                    query.addCriteria(Criteria.where(field).gt(value));
                } else if (key.endsWith("Gte")) {
                    String field = key.replace("Gte", "");
                    query.addCriteria(Criteria.where(field).gte(value));
                } else {
                    query.addCriteria(Criteria.where(key).is(value));
                }
            }
        }

        Pageable pageable = PageRequest.of(page, perPage);
        query.with(pageable);

        return mongoTemplate.find(query, ${className}.class);
    }
}