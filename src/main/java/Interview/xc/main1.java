package Interview.xc;

import java.util.Scanner;

/**
 * @Description: 题目描述：
 * 游游今年就要毕业了，和同学们在携程上定制了日本毕业旅行。愉快的一天行程结束后大家回到了酒店房间，这时候同学们都很口渴，石头剪刀布选出游游去楼下的自动贩卖机给大家买可乐。
 * <p>
 * 贩卖机只支持硬币支付，且收退都只支持10 ，50，100 三种面额。一次购买行为只能出一瓶可乐，且每次购买后总是找零最小枚数的硬币。（例如投入100圆，可乐30圆，则找零50圆一枚，10圆两枚）
 * <p>
 * 游游需要购买的可乐数量是 m，其中手头拥有的 10,50,100 面额硬币的枚数分别是 a,b,c，可乐的价格是x(x是10的倍数)。
 * <p>
 * 如果游游优先使用大面额购买且钱是够的情况下,请计算出需要投入硬币次数？
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 依次输入，
 * <p>
 * 需要可乐的数量为 m
 * <p>
 * 10元的张数为 a
 * <p>
 * 50元的张数为 b
 * <p>
 * 100元的张树为 c
 * <p>
 * 1瓶可乐的价格为 x
 * <p>
 * 输出描述
 * 输出当前金额下需要投入硬币的次数
 * <p>
 * 例如需要购买2瓶可乐，每瓶可乐250圆，手里有100圆3枚，50圆4枚，10圆1枚。
 * <p>
 * 购买第1瓶投递100圆3枚，找50圆
 * <p>
 * 购买第2瓶投递50圆5枚
 * <p>
 * 所以是总共需要操作8次金额投递操作
 * @author: Anhlaidh
 * @date: 2020-10-13 09:59
 */
public class main1 {
    static int buyCoke(int m, int a, int b, int c, int x) {
        int[] money = new int[3];
        money[0] = a;
        money[1] = b;
        money[2] = c;
        int count = process(m, money, x, 0,x);
        return count;

    }

    // 1 5 10 ,x/10


    private static int process(int m,int[] money, int x, int count,int val) {
        int result = count;

        if (x <= 0) {
            m--;
            int abs = Math.abs(x);
            x = val;
            if (abs >= 50) {
                 money[1]++;
                abs -= 50;
            } if (abs >= 10) {
                for (int i = 0; i < abs/10; i++) {
                    money[0]+=1;
                }
            }
        }
        if (m==0) return count;

        if (money[2] != 0) {
            money[2]--;
            result =  process(m,money, x - 100, ++count,val);

        } else if (money[1] != 0) {
            money[1]--;
            result = process(m, money, x - 50, ++count,val);

        } else if (money[0] != 0) {
            money[0]--;
            result = process(m, money, x - 10, ++count,val);
        }
        return result;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int m = reader.nextInt();
        int a = reader.nextInt();
        int b = reader.nextInt();
        int c = reader.nextInt();
        int x = reader.nextInt();
        System.out.println(buyCoke(m,a,b,c,x));

    }
}
