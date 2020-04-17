package HomeWork.Chapter04;

import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/14 0014 17:03
 */
public class Hanoi {
    void hanoi(int n, char A,char B,char C){
        if (n==1) System.out.println(A+"->"+C);
        else {
            hanoi(n-1,A,C,B);
            System.out.print(A+"->"+C+"  ");
            hanoi(n-1,B,A,C);
        }
    }
    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(10,'A','B','C');

    }
}
