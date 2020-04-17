package Java.JavaLearning_Advanced.HTTP.HttpComponet;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 16:53
 */
public class HttpComponentsGet {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(5000)//设置超时时间
                .setConnectionRequestTimeout(5000)//设置请求超时时间
                .setSocketTimeout(5000)
                .setRedirectsEnabled(true)//默认允许自动重定向
                .build();
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        httpGet.setConfig(requestConfig);
        String strResult = "";
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                strResult = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");//获得返回结果
                System.out.println(strResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
