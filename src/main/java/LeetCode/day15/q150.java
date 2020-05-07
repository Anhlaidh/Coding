package LeetCode.day15;

import java.util.Stack;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-04-29 13:01
 */
public class q150 {
    public static void main(String[] args) {
        String[] chars = {
                "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
        };
        System.out.println(evalRPN(chars));

    }
    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                opr("+", stack);
                continue;
            }
            if ("-".equals(tokens[i])) {
                opr("-", stack);
                continue;
            }
            if ("*".equals(tokens[i])) {
                opr("*", stack);
                continue;
            }
            if ("/".equals(tokens[i])) {
                opr("/", stack);
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.pop());


    }

    private static void opr(String s, Stack<String> stack) {
        int b = Integer.parseInt(stack.pop());
        int a = Integer.parseInt(stack.pop());
        if ("+".equals(s)) {
            stack.push(a + b + "");
        }if ("-".equals(s)) {
            stack.push(a - b + "");
        }if ("*".equals(s)) {
            stack.push(a * b + "");
        }if ("/".equals(s)) {
            stack.push(a / b + "");
        }

    }
}
