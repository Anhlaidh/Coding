package LeetCode.day12.q1006;

/**
 * @Description:暴力
 * @author: Anhlaidh
 * @date: 2020-04-16 13:30
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(clumsy(5));

    }

    public static int clumsy(int N) {
        int result = N;
        if (N==1) {
            return 1;
        }
        if (N==2) {
            return 2;
        }
        if (N>=3){
            // N*(N-1) continue
            result = result * (--N);
            // N/(N-1) continue
            result = result / (--N);
            // N+(N-1) continue
            result = result + (--N);
        }
        while (N > 0) {
            int temp = --N;

            if (N>1) {
                temp *= (--N);
            }
            if (N>1) {
                temp /= --N;
            }
            if (N>1) {
                result += --N;
            }

            result -= temp;
        }

        return result;
    }
}
