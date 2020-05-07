package exam.exam4;

import java.util.Stack;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-29 10:59
 */
public class myqueue {
    class MyQueue {
        Stack<Integer> input;
        Stack<Integer> output;

        /** Initialize your data structure here. */
        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();

        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            while (!output.isEmpty()) {
                input.push(output.pop());
            }
            input.push(x);

        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
            return output.pop();

        }

        /** Get the front element. */
        public int peek() {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
            return output.peek();

        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            if (input.isEmpty() && output.isEmpty()) {
                return true;
            }
            return false;

        }
    }
}
