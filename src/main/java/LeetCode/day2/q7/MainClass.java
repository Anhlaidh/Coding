package LeetCode.day2.q7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description: reverse
 * @author: Anhlaidh
 * @date: 2020/1/21 0021 13:47
 */
class Solution {
    public int reverse(int x) {
//        String str= x+"";
//        StringBuilder sb = new StringBuilder();
//        char[] chars = str.toCharArray();
//        if ('-'==(chars[0])){
//            for (int i=chars.length-1;i>0;i--){
//                sb.append(chars[i]);
//            }
//            sb.insert(0,"-");
//        }else{
//            for (int i=chars.length-1;i>=0;i--){
//                sb.append(chars[i]);
//            }
//        }
//        BigDecimal bd= new BigDecimal(sb.toString());
//       if (bd.compareTo(BigDecimal.valueOf(Integer.MAX_VALUE))==1) return 0;
//       if (bd.compareTo(BigDecimal.valueOf(Integer.MIN_VALUE))==-1) return 0;
//       else return bd.intValue();

        int rev=0;
        while (x!=0){
            int newRev=rev*10+x%10;
            if ((newRev-x%10)/10!=rev) return 0;
            rev =newRev;
            x/=10;
        }
        return rev;
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new Solution().reverse(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}