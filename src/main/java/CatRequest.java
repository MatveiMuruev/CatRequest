import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class CatRequest {
    private final static String URI = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet get = new HttpGet(URI);
        CloseableHttpResponse response = httpClient.execute(get);

        ObjectMapper mapper = new ObjectMapper();
        List<CatFacts> catFactsList = mapper.readValue(response.getEntity().getContent(), new TypeReference<>() {
        });

        Stream stream = catFactsList.stream().filter(value -> value.getUpvotes() > 0)
                .map(CatFacts::getText);
        stream
                .forEach(System.out::println);
    }
}
