package wx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/29 0029 14:14
 */
public class URLConnectionGet {
    public static void main(String[] args) {
        try {
            String urlName = "https://api-hmugo-web.itheima.net/api/public/v1";
            URL url = new URL(urlName+"/categories");
            URLConnection connection = url.openConnection();
            connection.connect();
            //打印Http的头部信息
            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                for (String value : entry.getValue()) {
                    System.out.println(key + ":" + value);
                }
            }
            //输出将要收到的内容属性信息
            System.out.println("-------------------");
            System.out.println("getContentType" + connection.getContentType());
            System.out.println("getContentLength" + connection.getContentLength());
            System.out.println("getContentEncoding" + connection.getContentEncoding());
            System.out.println("getDate" + connection.getDate());
            System.out.println("getExpiration" + connection.getExpiration());
            System.out.println("getLastModified" + connection.getLastModified());
            System.out.println("-------------------");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            //输出收到的内容
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
