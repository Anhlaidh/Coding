package HomeWork.Chapter11;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-06-05 14:56
 */

//FAILUREEISATHEBMOTHERCCFDSUCCESS
//SUCCE
public class horsPool {
    public static void main(String[] args) {
        String S = "FAILUREEISATHEBMOTHERCCFDSUCCESS";
        String P = "SUCCE";
        int end = solution(S, P);
        System.out.println("开始位置:"+(end-P.length()+1)+"结束位置:"+ end);
    }

    private static int solution(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        char tail = pattern[pattern.length - 1];
        int end = pattern.length - 1;
        while (end < str.length) {
            if (str[end] == tail) {
                int i = 0;
                while (i < pattern.length) {
                    if (str[end - pattern.length + i+1] != pattern[i]) {
                        break;
                    }
                    i++;
                }
                if (i == pattern.length) {
                    return end;
                } else {
                    end++;
                }


            } else {
                int n = 0;
                while (n <= pattern.length - 1) {
                    if (pattern[pattern.length-n-1] ==str[end]) {
                        break;
                    }
                    n++;
                }
                end += n;


            }

        }
        return -1;


    }
}
