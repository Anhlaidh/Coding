package Java.JavaLearning_Advanced.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/23 0023 19:21
 */
public class MatcherDemo {
    private static final String REGEX = "\\bdog\\b";//\b表示边界
    private static final String INPUT = "dog dog dog doggie dogg";

    public static void main(String[] args) {
        //检查字符串里有多少个dog
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Match number" + count);
            System.out.println("start()" + matcher.start());
            System.out.println("end()" + matcher.end());
        }
//        String f = "fooooooooooooo";
//        matcher.lookingAt();//不完全匹配,匹配foo为true
//        matcher.find();//完全匹配，匹配foo为false
    }
}
