package LeetCode.everyday;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-13 18:35
 */
public class q24 {
    /**
     * Definition for singly-linked list.
     */
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


    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nowHead = head.next;
        ListNode cur = head;
        ListNode before = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (before != null) {
                before.next = next;
            }
            if (next != null) {
                cur.next = next.next;
                next.next = cur;
                before = cur;
            } else{
                before.next = cur;
            }
            cur = cur.next;
        }
        return nowHead;

    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,null)))));
        ListNode node = swapPairs(a);
        while (node.next != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println(node.val);
    }

}
