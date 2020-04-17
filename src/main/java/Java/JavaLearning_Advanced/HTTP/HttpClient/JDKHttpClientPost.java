package Java.JavaLearning_Advanced.HTTP.HttpClient;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 15:43
 */
public class JDKHttpClientPost {
    public static void main(String[] args) {
        doPost();
    }

    private static void doPost() {
        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://zh-tools.usps.com/zip-code-lookup.htm?byaddress"))
                    .header("User-Agent", "HTTPie/0.9.2")
                    .header("Content-Type", "application/x-www-form-urlencoded;charset=utf-8")
                    .POST(HttpRequest.BodyPublishers.ofString(
                            "tAdress=" + URLEncoder.encode("1 Market Street", "UTF-8") +
                                    "tCity="+ URLEncoder.encode("San Francisco", "UTF-8") +
                                    "sState="+ "CA")
                    ).build();
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.statusCode());
            System.out.println(response.headers());
            System.out.println(response.body().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
