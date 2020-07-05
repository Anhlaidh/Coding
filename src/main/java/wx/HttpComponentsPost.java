package wx;

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
//        https://zh-tools.usps.com/zip-code-lookup.htm?byaddress
//        HttpPost httpPost = new HttpPost("https://api-hmugo-web.itheima.net/api/public/v1/home/swiperdata");
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8787/login");
        //配置post参数
        List<BasicNameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("tel", URLEncoder.encode("123123123", "UTF-8")));

//        list.add(new BasicNameValuePair("tAdress", URLEncoder.encode("1 Market Street", "UTF-8")));//请求参数
//        list.add(new BasicNameValuePair("tCity", URLEncoder.encode("San Francisco", "UTF-8")));//请求参数
//        list.add(new BasicNameValuePair("sState", "CA"));//请求参数
//        list.add(new BasicNameValuePair("code", URLEncoder.encode("033rbuqT1BJmw31FAspT1icrqT1rbuqb", "UTF-8")));
//        list.add(new BasicNameValuePair("encryptedData", URLEncoder.encode("RTRqsLy10FO3eTdFmikDA3yvliwdH5y9Zg/l+He6Mr3jmJ9Rc+…uRpZ+t+brTBVNwTq8aIXcoGItdLIh0KRl/okFNDWsky2telc=", "UTF-8")));
//        list.add(new BasicNameValuePair("iv", URLEncoder.encode("xmXGriadT8yIvSQeg6pOqA==", "UTF-8")));
//        list.add(new BasicNameValuePair("signature", URLEncoder.encode("26b203e04a5d0a0014764bb079352cdbbb704442", "UTF-8")));
//        list.add(new BasicNameValuePair("rawData", URLEncoder.encode("{\"nickName\":\"神鸦\",\"gender\":1,\"language\":\"zh_CN\",\"ci…RhibzPgGMicZ3TicnfgKTicicZUvSv8eRswKnNdV5BA/132\"}", "UTF-8")));
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
