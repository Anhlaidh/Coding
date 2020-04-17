package Tools.mj;

import java.util.Scanner;

/**
 * @Description: scan
 * @author: Anhlaidh
 * @date: 2020/2/21 0021 16:41
 */
public class testscan {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNext()){
            int A = reader.nextInt();
            int B =reader.nextInt();
            System.out.println(A+"//////"+B);
        }
    }
}
