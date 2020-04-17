package LeetCode.day1.q6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/1/20 0020 19:36
 */
class Solution {
    public String convert(String s, int numRows) {
    StringBuilder[] sb = new StringBuilder[numRows];
    for (int i =0;i<sb.length;i++) sb[i] = new StringBuilder();
    char[] chars = s.toCharArray();
    int i=0;
    while (i<chars.length){
        for (int j=0;j<numRows&&i<chars.length;j++){
            sb[j].append(chars[i++]);
        }
        for (int j =numRows-2;j>=1&&i<chars.length;j--){
            sb[j].append(chars[i++]);
        }
    }

     for (int j=1;j<numRows;j++){
         sb[0].append(sb[j]);
     }

    return sb[0].toString();
    }
}

public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            int numRows = Integer.parseInt(line);

            String ret = new Solution().convert(s, numRows);

            String out = (ret);

            System.out.print(out);
        }
    }
}