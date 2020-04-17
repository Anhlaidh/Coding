package HomeWork.Chapter02;


import HomeWork.TimeTool.TimeTool;

/**
 * @Description: cock->5 hen->3 chick->1/3
 * @author: Anhlaidh
 * @date: 2020/2/28 0028 16:10
 */

public class hundred {
    static void resolve_a(int N){
        for (int cock=0;cock<N/5;cock++){
            for (int hen=1;hen<N/3;hen++){
                for (int chick=3;chick<99;chick+=3){
                    if (cock*5+hen*3+chick/3==100&&cock+hen+chick==100)
                    {System.out.print("cock:"+cock);
                        System.out.print("hen:"+hen);
                        System.out.print("chick:"+chick);
                        System.out.print("\t");}
                }
            }
        }
    }
    static void resolve_b(int N){
        //y = 25-7/4x
        //z=100-x-y
        for (int cock=0;cock<N/5;cock++){
            if (7*cock%4!=0) continue;
            int hen = 25-(7*cock/4);
            int chick=100-hen-cock;
            if (hen<0||chick%3!=0) continue;
            if ((5*cock+hen*3+chick/3)==100) {
                System.out.print("cock:"+cock);
                System.out.print("hen:"+hen);
                System.out.print("chick:"+chick);
                System.out.print("\t");
            }
        }

    }

    public static void main(String[] args) {
        TimeTool.check("resolve_a", new TimeTool.Task() {
            @Override
            public void execute() {
                resolve_a(100);
            }
        });
        TimeTool.check("resolve_b", new TimeTool.Task() {
            @Override
            public void execute() {
                resolve_b(100);
            }
        });
    }
}
