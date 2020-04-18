package HomeWork.Chapter08;

import HomeWork.TimeTool.TimeTool;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-18 16:20
 */
public class pow {
    public static void main(String[] args) {
        TimeTool.check("test1", new TimeTool.Task() {
            @Override
            public void execute() {
                System.out.println(myPow(-1 ,2147483647));
            }
        });
        TimeTool.check("test2", new TimeTool.Task() {
            @Override
            public void execute() {
                double a = 0.000001;
                for (int i = 0; i < 2147483647; i++) {
                    a *= a;
                }
            }
        });


    }

    public static int getPow(double n, double m) {
        if (m==1) return (int) n;
        if (m==0) return 1;
        return (int)getPow(n, Math.floor(m/2)) * getPow(n, Math.ceil(m/2));

    }
    public static double myPow(double x, int n) {
        if (x==1) return 1;
        if (x == -1) {
            if (n%2==0) return 1;
            if (n%2!=0) return -1;
        }
        if ((-1<x&&x<1&&n>=1000000)||n<=-1000000) return 0.0;
        if (n==-1) return 1 / x;
        if (n==1) return x;
        if (n==0) return 1;
        if (n % 2 != 0 && n > 0) {
            return myPow(x, n / 2) * myPow(x, (n / 2) + 1);
        } else if (n % 2 != 0 && n < 0) {
            return myPow(x, n / 2) * myPow(x, (n/2)-1);
        } else return myPow(x, n / 2) * myPow(x, n / 2);

    }
}
