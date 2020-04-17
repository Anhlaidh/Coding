package Java.JavaLearning_Advanced.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 19:39
 */
public class ReplaceDemo {
    public static void Replace_1() {
        String REGEX = "a*b";//*表示限定前面的a可以有0个或者多个
        String INPUT = "aavfooabfooabafoobcdd";
        String REPLACE = "-";
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

    public static void Replace_2() {
        String REGEX = "dog";//*表示限定前面的a可以有0个或者多个
        String INPUT = "The dog says meow.All dogs say meow";
        String REPLACE = "cat";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        INPUT = matcher.replaceAll(REPLACE);
        System.out.println(INPUT);

    }
}
