package LeetCode.everyday;

import java.util.LinkedList;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2021-03-13 20:52
 */
public class q705 {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1));; // 返回 True
        System.out.println(myHashSet.contains(3));; // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2));; // 返回 True
        myHashSet.remove(2);   // set = [1]
        myHashSet.remove(2);   // set = [1]
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2));; // 返回 False ，（已移除）
        System.out.println();

    }



    static class  MyHashSet {
        class Node{
            int val;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        /**
         * Initialize your data structure here.
         */
        Node[] set = null;
        public MyHashSet() {
            set = new Node[16];
        }

        public void add(int key) {
            if (contains(key)) {
                return;
            }
            int hashcode = key % set.length;
            if (set[hashcode] == null) {
                set[hashcode] = new Node(key);
                return;
            }
            Node cur = set[hashcode];
            //TODO 初始为null?
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(key);

        }

        public void remove(int key) {
            int hashcode = key % set.length;
            Node cur= set[hashcode];
            if (cur==null) return;
            if (cur.val == key) {
                set[hashcode] = cur.next;
                return;
            }
            Node next = cur.next;
            while (next.next != null) {
                if (next.val == key) {
                    cur.next = next.next;
                    next.next = null;
                    break;
                }
                cur = next;
                next = next.next;
            }


        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int hashcode = key % set.length;
            Node cur = set[hashcode];
            while (cur != null) {
                if (cur.val==key) return true;
                cur = cur.next;
            }
            return false;

        }
    }
}
