package Interview.Left.review.stack;

import java.util.Random;
import java.util.Stack;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-10 15:34
 */
public class stackToQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        int[] arr = new Random().ints(10, 0, 100).toArray();
        for (int i = 0; i < arr.length; i++) {
            queue.push(arr[i]);
            System.out.print(arr[i] +"\t");
        }
        System.out.println();
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());

        }

    }

    private static class MyQueue {
        Stack<Integer> input = new Stack<>();
        Stack<Integer> output = new Stack<>();

        boolean isEmpty() {
            return input.isEmpty() && output.isEmpty();
        }

        void push(int i) {
            input.push(i);
        }

        Integer pop() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.pop();

        }
    }
}
