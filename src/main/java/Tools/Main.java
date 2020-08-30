package Tools;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
        int begin=in.nextInt();
        int end=in.nextInt();
        for(int a=begin;a<=end;a++) {
            System.out.print(a+"=");
            prime_String(a);
        }
    }
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
            else {
                k++;
            }
        }
        System.out.println(str);
    }
}


