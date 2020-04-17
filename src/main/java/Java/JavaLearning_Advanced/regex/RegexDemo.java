package Java.JavaLearning_Advanced.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 19:30
 */
public class RegexDemo {
    private static String REGEX = "a*b";//*表示限定前面的a可以有0个或者多个
    private static String INPUT = "aavfooabfooabafoobcdd ";
    private static String REPLACE = "-";

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        StringBuffer stringBuffer = new StringBuffer();
        // 全部替换
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, REPLACE);
        }
        //最后将尾巴字符串附加上
        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer.toString());
    }
}
