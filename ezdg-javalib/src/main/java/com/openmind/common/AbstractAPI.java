package common;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public abstract class AbstractAPI<T> {
    private final ObjectMapper mapper = new ObjectMapper();
    protected URIBuilder uriBuilder;


    public AbstractAPI(String endpoint) {
        uriBuilder = new URIBuilder().setScheme("http").setHost("localhost:8080").setPath(endpoint);
    }

    protected String encode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // 발생할 가능성이 거의 없기 때문에 런타임 예외로 래핑하여 던집니다.
            throw new RuntimeException("UTF-8 encoding is not supported", e);
        }
    }

    /**
     * @param page 조회할 페이지 번호 - 0 이상이어야합니다.
     */
    public AbstractAPI<T> page(int page) {
        if (page <= 0) throw new IllegalArgumentException("Page number must be a positive integer.");
        uriBuilder.setParameter("page", String.valueOf(page));
        return this;
    }

    /**
     * @param perPage 한 번에 조회할 데이터의 수
     */
    public AbstractAPI<T> perPage(int perPage) {
        if (perPage <= 0) throw new IllegalArgumentException("Per-page count must be a positive integer.");
        uriBuilder.setParameter("perPage", String.valueOf(perPage));
        return this;
    }

    public List<T> fetch() throws URISyntaxException, IOException {
        URL url = uriBuilder.build().toURL();
        System.out.println(url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            JsonNode rootNode = mapper.readTree(reader);
            JsonNode contentNode = rootNode;
            List<T> result = mapper.convertValue(contentNode, new TypeReference<List<T>>() {
            });
            reader.close();
            conn.disconnect();
            return result;
        } else {
            throw new IOException("Failed to fetch data. HTTP response code: " + conn.getResponseCode());
        }
    }
}
