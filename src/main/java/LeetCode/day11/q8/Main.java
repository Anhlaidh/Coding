package LeetCode.day11.q8;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-14 14:07
 */
public class Main {
    public static void main(String[] args) {
        System.out.println( myAtoi("3.ith words"));

    }
    public static int myAtoi(String str) {
        long result = 0;
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c !=' '&& i<str.length()-1&&!(str.charAt(i+1)>=48&&c<58)&&!(c>=48&&c<58)) {
                return 0;
            }
            if (c ==' '|| c =='+'|| c =='-') {
                continue;
            }

            if (c >= 48 && c < 58) {
                if (i!=0&&str.charAt(i-1)=='-') {
                    flag = true;
                }

                int temp = i;
                while (i < str.length() && (str.charAt(i) < 58&& str.charAt(i) >=48)) {
                    i++;
                }
                char[] chars = str.substring(temp, i).toCharArray();
                int[] value = new int[chars.length];


                for (int j = 0; j < chars.length; j++) {
                    value[j] = chars[j] - 48;
                    result = result * 10 + value[j];
                    if (result/10>Integer.MAX_VALUE) {
                        break;
                    }
                }
                break;

            } else {
                return 0;
            }
        }
        if (flag) {
            result= 0- result;
        }
        if (result<Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        } else if (result>Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;

    }
}
