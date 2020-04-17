package Java.JavaLearning_Advanced.HTTP;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 14:42
 */
public class URLConnectionPost {
    public static void main(String[] args) throws IOException {
        String url = "https://zh-tools.usps.com/zip-code-lookup.htm?byaddress";
        Object userAgent = "Httpie/0.9.2";
        Object redirects = "1";
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));

        Map<String, String> params = new HashMap<String, String>();
        params.put("tAddress", "1 Market Street");
        params.put("tCity", "San Francisco");
        params.put("sState", "CA");
        String result = doPost(new URL(url), params,
                userAgent == null ? null : userAgent.toString(),
                redirects == null ? -1 : Integer.parseInt(redirects.toString()));
        System.out.println(result);
    }

    private static String doPost(URL url, Map<String, String> nameValueParis, String userAgent, int redirects) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (userAgent != null) {
            connection.setRequestProperty("User-Agent", userAgent);
        }
        if (redirects >= 0) {
            connection.setInstanceFollowRedirects(false);
            connection.setDoOutput(true);
        }
        //输出请求的参数
        try (PrintWriter out = new PrintWriter(connection.getOutputStream())) {
            boolean first = true;
            for (Map.Entry<String, String> pair : nameValueParis.entrySet()) {
                //参数必须这样拼接a=1&b=2&c=3
                if (first) {
                    first = false;
                } else {
                    out.println('&');
                }
                String name = pair.getKey();
                String value = pair.getValue();
                out.print(name);
                out.print('=');
                out.print(URLEncoder.encode(value, "UTF-8"));
            }
            String encoding = connection.getContentEncoding();
            if (encoding == null) {
                encoding = "UTF-8";
            }
            if (redirects > 0) {
                int responseCode = connection.getResponseCode();
                System.out.println("responseCode:" + responseCode);
                if (responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_MOVED_TEMP ||
                        responseCode == HttpURLConnection.HTTP_SEE_OTHER) {
                    String location = connection.getHeaderField("Location");
                    if (location != null) {
                        URL base = connection.getURL();
                        connection.disconnect();
                        return doPost(new URL(base, location), nameValueParis, userAgent, redirects - 1);
                    }
                }
            } else if (redirects == 0) {
                throw new IOException("too many redirects");
            }
            //获取html内容
            StringBuilder response = new StringBuilder();
            try (Scanner in = new Scanner(connection.getInputStream(), encoding)) {
                while (in.hasNextLine()) {
                    response.append(in.nextLine());
                    response.append("\n");
                }
            } catch (IOException e) {
                InputStream err = connection.getErrorStream();
                if (err == null) {
                    throw e;
                }
                try (Scanner in = new Scanner(err)) {
                    response.append(in.nextLine());
                    response.append("\n");
                }
            }
            return response.toString();
        }


    }
}
