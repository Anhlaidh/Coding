package HomeWork.Chapter08;

/**
 * @Description: 给定一个数,获取这个数所有可能的累加形式,变态跳青蛙组合版
 * @author: Anhlaidh
 * @date: 2020-04-17 15:47
 */
public class Count {
    public static void main(String[] args) {
        System.out.println(count(6));

    }

    /**
     * 计数
     * @param n 输入的参数
     * @return 所有可能的数量
     */
    public static int count(int n) {
        return count(n, n);

    }

    private static int count(int n, int m) {
        if (n < 1 || m < 1) {
            return 0;
        }
        if (n == 1 || m == 1) {
            return 1;
        }
        if (n < m) {
            return count(n, n);
        }
        if (n == m) {
            return count(n, m - 1) + 1;

        }
        return count(n, m - 1) + count(n - m, m);
    }
}
