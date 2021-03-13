package test;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2021-02-06 16:43
 */
public class testOut {
    String str = "good";
    char[] c = new char[]{
            'a', 'b', 'c'};

    public static void main(String[] args) {
        testOut test = new testOut();
        test.exchange(test.str, test.c);
        System.out.println(test.str+"\t"+test.c[0]);

    }

    private void exchange(String str, char[] c) {
        str = "hello";
        c[0] = 'b';
    }
}
