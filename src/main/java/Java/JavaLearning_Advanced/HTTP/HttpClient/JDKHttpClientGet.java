package Java.JavaLearning_Advanced.HTTP.HttpClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 15:38
 */
public class JDKHttpClientGet {
    public static void main(String[] args) {
        doGet();
    }

    private static void doGet() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://www.baidu.com")).build();
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
