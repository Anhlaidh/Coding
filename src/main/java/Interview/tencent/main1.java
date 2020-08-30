package Interview.tencent;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-08-23 20:00
 */
public class main1 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int k = reader.nextInt();
        Node node = new Node();
        Node head = node;
        node.val = reader.nextInt();
        for (int i = 0; i < n-1; i++) {
            node.next = new Node(reader.nextInt());
            node = node.next;
        }
        Node del = del(head, k);
        print(del);



    }
    static void print(Node head){
        while (head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    static Node del(Node head,int key) {
        if (key<=0) {
            return head;
        }
        if (key==1) {
            return head.next;
        }
        Node node = head;
        for (int i = 0; i < key-2; i++) {
            node = node.next;
        }
        node.next = node.next.next;
        return head;

    }


    private static class Node {
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
