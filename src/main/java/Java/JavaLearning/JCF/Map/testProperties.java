package Java.JavaLearning.JCF.Map;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/18 0018 22:01
 */
public class testProperties {
    public static void main(String[] args) throws IOException {
        System.out.println("写入Test.Properties===========");
        WriteProperties("Test.properties","name","12345");
        System.out.println("加载Test.Properties===========");
        GetAllProperties("Test.properties");
        System.out.println("从Test.properties加载=========");
        String value = GetValueByKey("Test.properties", "name");
        System.out.println("name is"+value);
    }

    private static String GetValueByKey(String filePath, String key) {
        Properties properties = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            properties.load(in);//所有的K-V都加载了
            String value = properties.getProperty(key);
            System.out.println(key + "=" + value);
            return value;
        } catch (IOException e) {
            e.printStackTrace();
            return null;

        }
    }

    //读取properties全部信息
    private static void GetAllProperties(String filePath) throws IOException {
        Properties properties = new Properties();
        InputStream in = new BufferedInputStream(new FileInputStream(filePath));
        properties.load(in);//加载所有的K-V对
        Enumeration en = properties.propertyNames();
        while (en.hasMoreElements()) {
            String strKey = (String)en.nextElement();
            String strValue = properties.getProperty(strKey);
            System.out.println(strKey+"="+strValue);
        }

    }
//写入Properties全部信息
    private static void WriteProperties(String filePath,String pKey,String pValue) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        Properties properties = new Properties();
        InputStream in = new FileInputStream(filePath);
        //从输入流中读取属性列表（键和元素对）
        properties.load(in);
        //调用Hashtable的方法put，使用getProperty方法提供并行性
        //强制要求为属性的键和值使用字符串，返回值是Hashtable调用put的结果
        OutputStream out = new FileOutputStream(filePath);
        properties.setProperty(pKey, pValue);
        //以合适使用load方法加载到Properties表中的格式
        //将此Properties表中的属性列表（键和元素对）写入输出流
        properties.store(out, "Update"+pKey+"name");
        out.close();
    }

}
