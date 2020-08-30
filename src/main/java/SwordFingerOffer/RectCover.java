package SwordFingerOffer;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-30 09:20
 */
public class RectCover {
    public static void main(String[] args) {

    }
    public int RectCover(int target) {
        if (target==0 || target==1 || target==2) return target;
        int a = 1, b = 2, c=0;
        for (int i=3; i<=target; ++i) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
