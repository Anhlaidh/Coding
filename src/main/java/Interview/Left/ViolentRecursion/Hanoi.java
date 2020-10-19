package Interview.Left.ViolentRecursion;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-18 16:46
 */
public class Hanoi {
    // 六次循环调用写法
    // 递归


    public static void main(String[] args) {
        int n = 3;
        hanoi(n);
    }

    private static void hanoi(int n) {
        process(n, "left", "mid", "right");

    }

    private static void process(int n, String from, String other, String to) {
        if (n == 1) {
            System.out.println("move " + from + " to " + to);
        } else {
            process(n - 1, from, to, other);
            System.out.println("move " + from + " to " + to);
            process(n - 1, other, from, to);

        }
    }
}
