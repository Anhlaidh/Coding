package SwordFingerOffer;

import java.util.Stack;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-15 13:41
 */
public class queue {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        System.out.println(solution.pop());
        solution.push(3);
        System.out.println(solution.pop());
        solution.push(4);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }
}
class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }
}