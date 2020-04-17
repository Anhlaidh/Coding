package Java.JavaLearning_Advanced.HTTP.HttpComponet;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 17:03
 */
public class HttpComponentsPost {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //获取可关闭的httpClient
        //CloseableHttpClient
        CloseableHttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
        //配置超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000)
                .setConnectTimeout(10000)
                .setConnectionRequestTimeout(10000)
                .setRedirectsEnabled(false).build();
        HttpPost httpPost = new HttpPost("https://zh-tools.usps.com/zip-code-lookup.htm?byaddress");
        //配置post参数
        List<BasicNameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("tAdress", URLEncoder.encode("1 Market Street", "UTF-8")));//请求参数
        list.add(new BasicNameValuePair("tCity", URLEncoder.encode("San Francisco", "UTF-8")));//请求参数
        list.add(new BasicNameValuePair("sState", "CA"));//请求参数
        try {
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
            // 设置post请求参数
            httpPost.setEntity(entity);
            httpPost.setHeader("User-Agent", "HTTPie/0.9.2");
            HttpResponse httpResponse = httpClient.execute(httpPost);
            String result = "";
            if (httpResponse != null) {
                int statusCode = httpResponse.getStatusLine().getStatusCode();
                System.out.println(statusCode);
                if (statusCode == 200) {
                    result = EntityUtils.toString(httpResponse.getEntity());
                } else {
                    result = "ERROR Response" + httpResponse.getStatusLine().toString();
                }
            } else {
            }
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
