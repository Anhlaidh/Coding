package Java.JavaLearning_Advanced.International;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 14:34
 */
public class HelloWorld {
    public static void main(String[] args) {
        //取得系统默认的国家/语言环境
        Locale myLocale = Locale.getDefault();
        System.out.println(myLocale);//zh_CN
        //根据指定语言，国家环境，加载资源文件
        ResourceBundle bundle = ResourceBundle.getBundle("message", myLocale);
        //从资源文件中获取信息
        System.out.println(bundle.getString("hello"));

    }
}
