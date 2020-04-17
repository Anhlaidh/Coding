package HomeWork.Chapter01;

import HomeWork.TimeTool.TimeTool;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/2/21 0021 14:39
 */
public class homeWork_01 {
     static int gcd_cir(int A,int B){
        while (A%B!=0){
            int C=A%B;
            A=B;
            B=C;
        }
        return B;
    }
     static int gcd_rec(int f,int s){
        if (s>0) return gcd_cir(s,f%s);
        return f;
    }
    //2 3 7 10 13
    //  5 10


    static int gcd(int A,int B){
         if (A==1||B==1) return 1;
        int[] a = prime(Math.max(A,B));
        int[] b = prime(Math.min(A,B));

        int[] temp = new int[b.length];
        for (int i=0;i<b.length;i++){
            for (int j=0;j<a.length;j++){
                if (b[i]==a[j]) {
                    temp[i]=b[i];
                    b[i]=0;
                    a[j]=0;
                }
            }
        }
        int res = 1;
        for (int i=0;i<temp.length;i++){
           if (temp[i]!=0) res*=temp[i];
        }
         return res;
    }
    static int[] prime(int n){
         int k=2;
        String str ="";
         while (k<=n){
             if (k==n) {
                 str+=k+" ";
                 break;
             }
             else if (n%k==0){
                 str= str+k+" ";
                 n=n/k;
             }
             else k++;
         }
//        System.out.println(str);
        String[] s =  str.split(" ");
        int[] res =new  int[s.length];
        for (int i=0;i<s.length;i++){
            res[i]=Integer.parseInt(s[i]);
        }
         return res;
    }
    static int doTest(int A,int B){
         for (int i =Math.min(A, B);i>=0;i--){
             if (A%i==0&&B%i==0) return i;
         }
         return 0;
    }
    public static void main(String[] args) {
//        Scanner reader = new Scanner(System.in);
//        while (reader.hasNext()){
//            System.out.println("input two numbers:");
//            int A = reader.nextInt();
//            int B =reader.nextInt();
//
//
//        TimeTool.check("递归辗转相除法", new TimeTool.Task() {
//            @Override
//            public void execute() {
//                System.out.println(gcd_rec(A,B));//递归辗转相除
//            }
//        });
//        TimeTool.check("循环辗转相除法", new TimeTool.Task() {
//            @Override
//            public void execute() {
//                System.out.println(gcd_cir(A,B));//循环辗转相除
//            }
//        });
//        TimeTool.check("质因子法", new TimeTool.Task() {
//            @Override
//            public void execute() {
//                System.out.println(gcd(A,B));//质因子法
//            }
//        });
//        TimeTool.check("循环测试法", new TimeTool.Task() {
//            @Override
//            public void execute() {
//                System.out.println(doTest(A,B));//循环测试法
//            }
//        });
//    }

//        Scanner in=new Scanner(System.in);
//        int begin=in.nextInt();
//        int end=in.nextInt();
        TimeTool.check("prime", new TimeTool.Task() {
            @Override
            public void execute() {

            }
        });


    }
    static void prime_String(int n){
        int k=2;
        String str ="";
        while (k<=n){
            if (k==n) {
                str+=k+" ";
                break;
            }
            else if (n%k==0){
                str= str+k+"*";
                n=n/k;
            }
            else k++;
        }
        System.out.println(str);
    }
}
