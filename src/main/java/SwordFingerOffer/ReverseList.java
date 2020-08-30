package SwordFingerOffer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-19 15:21
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = node1;
        ListNode test = node1;

        while (node!= null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
        node = new ReverseList().ReverseList(test);
        System.out.println();
        while (node!= null) {
            System.out.print(node.val + "\t");
            node = node.next;
        }
//        Stack<Integer> a = new LinkedList<Integer>();


    }

        public ListNode ReverseList(ListNode head) {
        if (head==null) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        while (node.next != null) {
            stack.push(node.val);
            node = node.next;
        }
        head = node;
        while (!stack.isEmpty()){
            node.next = new ListNode(stack.pop());
            node = node.next;
        }
        return head;

    }
//    public ListNode ReverseList(ListNode head) {
//       if (head ==null) return null;
//        ListNode pre = null;
//        ListNode next = null;
//        while (head != null) {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
//
//
//    }
//
//    public ListNode delete(ListNode head, Integer val) {
//        if (head==null) return null;
//        while (head.next != null) {
//            if (head.val != val) {
//                break;
//            }
//            head = head.next;
//        }
//        ListNode node = head.next;
//        ListNode pre = head;
//        while (node != null) {
//            if (node.val == val) {
//                pre.next = node.next;
//            }
//            pre = node;
//            node = node.next;
//
//        }
//        return head;
//
//     }
}

