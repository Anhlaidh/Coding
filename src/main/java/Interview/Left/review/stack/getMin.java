package Interview.Left.review.stack;

import java.util.Random;
import java.util.Stack;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-10 15:16
 */
public class getMin {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        int[] arr = new Random().ints(10, 0, 100).toArray();
        for (int i = 0; i < arr.length; i++) {
            myStack.push(arr[i]);
            System.out.print(arr[i] +"\t");
        }
        System.out.println();
        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop());
            System.out.println(" min : "+myStack.getMin());
        }
    }

    private static class MyStack {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();

        boolean isEmpty() {
            return stack.isEmpty();
        }
        int pop() {
            Integer pop = stack.pop();
            help.pop();
            return pop;
        }

        void push(int i) {
            stack.push(i);
            if (help.isEmpty() || i < help.peek()) {
                help.push(i);
            } else {
                help.push(help.peek());
            }
        }

        int getMin() {
            if (help.isEmpty()) return -1;
            return help.peek();

        }
    }
}
