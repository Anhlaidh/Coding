package LeetCode.everyday;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-24 22:41
 */
public class change {
    public static void main(String[] args) {
        String str = "[[0,1,0,0},\n" +
                " [1,1,1,0},\n" +
                " [0,1,0,0},\n" +
                " [1,1,0,0}}";
        Pattern pattern = Pattern.compile("\\[");
        Matcher matcher = pattern.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "{");
        }
        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer.toString());


    }
}
