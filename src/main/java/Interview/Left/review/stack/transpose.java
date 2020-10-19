package Interview.Left.review.stack;

import java.util.Random;
import java.util.Stack;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-10 16:10
 */
public class transpose {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new Random().ints(10, 0, 100).toArray();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
            System.out.print(arr[i] +"\t");
        }
        int last = transPose(stack);
        System.out.println();
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());

        }
        System.out.println(last);
    }

    private static int transPose(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }

        int last = transPose(stack);
        stack.push(result);
        return last;
    }
}
