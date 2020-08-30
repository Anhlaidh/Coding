package HomeWork.exam;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-24 15:23
 */
public class test1 {
    public static void main(String[] args) {
        char[] T = {
                '1', '0', '0', '1', '1', '0', '1', '1', '0', '1'
        };
        int n = T.length;
        String P = "1011";
        int m = P.length();


        System.out.println(find(T,n,P,m));
    }

    private static int find(char[] T, int n, String P, int m) {
        for (int i = 0; i < n; i++) {
            if (T[i] == P.charAt(0)) {
                int j = 1;
                for (; j < m; j++) {
                    if (i+j>n) {
                        break;
                    }
                    if (T[i+j]!=P.charAt(j)) {
                        break;
                    }
                }
                if (j==m) {
                    return i;
                }
            }
        }
        return 0;
    }
}
