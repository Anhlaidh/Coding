package exam.exam4;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Description:
 * 6
 * add 1
 * add 2
 * add 3
 * peek
 * poll
 * peek
 * @author: Anhlaidh
 * @date: 2020-04-26 21:25
 */
public class stacktoqueue {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        queue queue = new queue();
        for (int i = 0; i < N; i++) {
            String str = reader.next();
            if (" ".equals(str)) {
                System.out.println(-1);
            }
            if ("add".equals(str)) {
                queue.add(reader.nextInt());

            }
            if ("poll".equals(str)) {
                queue.poll();

            }
            if ("peek".equals(str)) {
                System.out.println(queue.peek());


            }


        }
    }

    public static class queue {
        Stack<Integer> input;
        Stack<Integer> output;

        public queue() {
            input = new Stack<Integer>();
            output = new Stack<Integer>();
        }

        //尾部插入x
        public void add(int element) {
           while (!output.isEmpty()){
                input.push(output.pop());
            }
            input.push(element);



        }

        //弹出队列头
        public int poll() {
           while (!input.isEmpty()){
                output.push(input.pop());
            }
            return output.pop();


        }

        //查询队列中元素
        public int peek() {
            while (!output.isEmpty()) {
                input.push(output.pop());
            }
            while (!input.isEmpty()){
                output.push(input.pop());
            }
            return output.peek();

        }

    }
}
