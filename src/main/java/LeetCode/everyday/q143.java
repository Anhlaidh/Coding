package LeetCode.everyday;

import java.util.Stack;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-20 10:08
 */
public class q143 {
    public static void main(String[] args) {
//        ListNode a = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,null)))));
        ListNode a = new ListNode(1, new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6,null))))));
        reorderList(a);
        ListNode node = a;
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }


    }

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

    public static void reorderList(ListNode head) {
        if(head==null||head.next==null) return ;
        ListNode tail = reserve(head);
        ListNode aNode = head;
        ListNode bNode = tail;
        while (aNode != null) {
            ListNode aNext = aNode.next;
            ListNode bNext = bNode.next;
            aNode.next = bNode;
            if (aNext == null && bNext != null) {
                bNode.next = bNext;
                break;

            }else {
                bNode.next = aNext;
            }
            aNode = aNext;
            bNode = bNext;
        }


    }

    private static ListNode slowFast(ListNode head) {
        if (head.next==null) return head;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode reserve = reserve(slow);
        slow.next = null;
        return reserve;

    }

    private static ListNode reserve(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode node = head;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node = node.next;
        }
        node.next = null;
        return head;

    }

    private static ListNode split(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        int n = 0;
        while (node != null) {
            stack.push(node);
            n++;
            node = node.next;
        }
        ListNode tail = null;
        int size = 0;
        if (!stack.isEmpty()) {
            tail = stack.pop();
            n--;
        }
        node = tail;
        while (size < n-1) {
            node.next = stack.pop();
            n--;
            size++;
            node = node.next;
        }
        node.next = null;
        stack.pop().next = null;
        return tail;
    }
}
