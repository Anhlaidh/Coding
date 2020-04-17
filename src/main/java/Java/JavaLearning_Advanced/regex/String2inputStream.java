package Java.JavaLearning_Advanced.regex;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 19:55
 */
public class String2inputStream {
    public static void main(String[] args) {
        //构造字符串列表
        List<String> names = new LinkedList<>();
        names.add("xiaohong");
        names.add("xiaoming");
        names.add("Daming");
        names.add("xiaohei");
        //合并为一个字符串，以逗号相连
        String nameStr = String.join(",", names);
        //将字符串作为默认输入流
        InputStream in = IOUtils.toInputStream(nameStr, Charsets.toCharset("UTF-8"));
        //重置系统的输入流
        System.setIn(in);
        //模拟键盘输入，这也是OJ平台测试用例输入的原理
        //此处也可以换成一个文件的输入流
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
