package LeetCode.everyday;

import java.util.List;
import java.util.Stack;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-18 19:28
 */
public class q19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 1; i <= 1; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        node = head;
        node = removeNthFromEnd(head, 2);
        System.out.print(node.val + "\t");
        while (node.next != null) {
            node = node.next;
            System.out.print(node.val + "\t");
        }

    }

        public static ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node.next != null) {
            stack.push(node);
            node = node.next;
        }
        stack.push(node);
        if (n==stack.size()) return head.next;
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode pop = stack.pop();
        pop.next = pop.next.next;
        return head;

    }
//    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        if (n)
//    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
