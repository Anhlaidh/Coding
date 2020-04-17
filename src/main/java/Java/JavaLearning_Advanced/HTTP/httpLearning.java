package Java.JavaLearning_Advanced.HTTP;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 18:33
 */
public class httpLearning {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(1000)
                .setConnectTimeout(1000)
                .setSocketTimeout(1000)
                .setRedirectsEnabled(false).build();
        HttpPost post = new HttpPost(URI.create("http://www.baidu.com"));
        List<NameValuePair> parameters = new ArrayList<>();
        String str = 430000+"";
        parameters.add(new BasicNameValuePair("name", str));
        HttpEntity httpEntity = new UrlEncodedFormEntity(parameters);
        post.setEntity(httpEntity);
        post.setHeader("User-Agent", "HTTPie/0.9.2");
        closeableHttpClient.execute(post);

    }
}
