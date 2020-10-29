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
        String str = "{{0,1],{6,8],{0,2],{5,6],{0,4],{0,3],{6,7],{1,3],{4,7],{1,4],{2,5],{2,6],{3,4],{4,5],{5,7],{6,9]]";
        Pattern pattern = Pattern.compile("]");
        Matcher matcher = pattern.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, "}");
        }
        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer.toString());


    }
}
