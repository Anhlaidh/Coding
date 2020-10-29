package LeetCode.everyday;

import test.testAnnotation.GanTa;

import java.util.Stack;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-23 11:22
 */
public class q234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
//        reserve(head);
        System.out.println(isPalindromeV2(head));
    }

    public static boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            if (!(stack.pop().val==head.val)) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
    public static boolean isPalindromeV2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tail = reserve(slow);
        ListNode res = tail;
        ListNode node = head;
        boolean result = true;
        while (node != null&&tail!=null) {
            if (tail.val != node.val) {
                result =  false;
            }
            node = node.next;
            tail = tail.next;
        }
        reserve(res);
        return result;
    }

    private static ListNode reserve(ListNode head) {
        if (head==null) return null;
        ListNode before = null;
        ListNode cur = head;
        ListNode next ;
        while (cur != null) {
            next = cur.next;
            cur.next = before;
            before = cur;
            cur = next;
        }
        return before;

    }

    public static boolean GMX_isPalindrome(ListNode head){
        //空 和 长度为 1的 链表返回 true
        if (head != null && head.next != null) {
            //判断链表长度  偶数 则 对半拆分 奇数 则 忽略中间数对半拆分
            int len = 0;
            ListNode temp = head;
            while (temp.next != null) {
                len++;
                temp = temp.next;
            }
            Stack<Integer> stack = new Stack<>();
            if (len % 2 == 0) {
                // 1 2 2 1 把 1 2 压入栈中 并让head的状态为 2 1
                for (int i = 0; i < (len / 2); i++) {
                    stack.push(head.val);
                    head = head.next;
                }
            } else {
                //1 2 3 2 1 把 1 2 压入栈中 head状态跳过3变为 2 1
                for (int i = 0; i < ((len - 1) / 2); i++) {
                    stack.push(head.val);
                    head = head.next;
                }
                head = head.next; // 跳过3
            }
            while (head != null) {
                if (stack.pop() != head.val) {
                    return false;
                }
                head = head.next;
            }
            return true;
        }
        return true;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
