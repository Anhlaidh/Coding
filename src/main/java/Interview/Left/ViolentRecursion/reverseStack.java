package Interview.Left.ViolentRecursion;

import java.util.Stack;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-18 17:09
 */
public class reverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(process(stack));
        reverse(stack);
        for (int i = 0; i < 9; i++) {
            System.out.println(stack.pop());
        }

    }

    private static void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int i = process(stack);
            reverse(stack);
            stack.push(i);
        }
    }


    private static int process(Stack<Integer> stack) {
        int  pop = stack.pop();
        if (stack.isEmpty()) {
            return pop;
        } else {

            int floor = process(stack);
            stack.push(pop);
            return floor;
        }
    }
}
