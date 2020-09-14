package Interview.tencent.s;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-06 19:58
 */
public class main1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        Node head1 = new Node();
        Node node = head1;
        //第一个链表赋值
        while (n-- > 0) {
            node.val = reader.nextInt();
            node.next = new Node();
            node = node.next;
        }
        n = reader.nextInt();
        Node head2 = new Node();
        node = head2;
        //第二个链表赋值
        while (n-- > 0) {
            node.val = reader.nextInt();
            node.next = new Node();
            node = node.next;
        }
        Node ans = solution(head1, head2);
        node = ans;


        while (node.next != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    private static Node solution(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return new Node(0);
        }
        Node cur1 = head1;
        Node cur2 = head2;
        Node ans = new Node();
        Node temp = ans;
        while (cur1.next != null || cur2.next != null) {
            while (cur1.val > cur2.val) {
                cur1 = cur1.next;

            }
            while (cur1.val < cur2.val) {
                cur2 = cur2.next;

            }
            if (cur1.val == cur2.val) {
                temp.val = cur1.val;
                temp.next = new Node();
                temp = temp.next;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }


        }
        return ans;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node() {

        }
    }

}
