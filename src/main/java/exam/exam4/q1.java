package exam.exam4;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Description:
 *
 *
2
7
PUSH 1
PUSH 2
TOP
POP
TOP
POP
POP
5
PUSH 1
PUSH 2
SIZE
POP
SIZE
 *
 *
 *
 * @author: Anhlaidh
 * @date: 2020-04-26 20:02
 */
public class q1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        for (int i = 0; i < N; i++) {
            queue queue = new queue();
            int n = reader.nextInt();
            for (int j = 0; j < n; j++) {
                String str = reader.next();
                if (" ".equals(str)) {
                    System.out.println(-1);
                }
                if ("PUSH".equals(str)) {
                    queue.push(reader.nextInt());
                }
                if ("CLEAR".equals(str)) {
                    queue.clear();
                }
                if ("TOP".equals(str)) {
                    try {
                        System.out.println(queue.top());
                    } catch (Exception e) {
                        System.out.println(-1);
                    }

                }
                if ("POP".equals(str)) {
                    try {
                        queue.pop();
                    } catch (Exception e) {
                        System.out.println(-1);
                    }
                }
                if ("SIZE".equals(str)) {
                    System.out.println(queue.getSize());

                }

            }
        }
    }
    private static class queue{
        LinkedList<Integer> elements;

        public queue() {
            elements = new <Integer>LinkedList();
        }

        void push(int element) {
            elements.add(element);

        }

        void clear() {
            elements.clear();
        }


        int getSize() {
            return elements.size();
        }

        Integer top() {
            return elements.get(0);
        }

        void pop() {
            elements.pop();
            }

    }


}


/**
 *
 * import java.util.Scanner;
 * public class Main {
 *     public static void main(String[] args) {
 *         Scanner reader = new Scanner(System.in);
 *         int N = reader.nextInt();
 *         for (int i = 0; i < N; i++) {
 *             queue queue = new queue();
 *             int n = reader.nextInt();
 *             for (int j = 0; j < n; j++) {
 *                 String str = reader.next();
 *                 if (" ".equals(str)) {
 *                     System.out.println(-1);
 *                 }
 *                 if ("PUSH".equals(str)) {
 *                     queue.push(reader.nextInt());
 *                 }
 *                 if ("CLEAR".equals(str)) {
 *                     queue.clear();
 *                 }
 *                 if ("TOP".equals(str)) {
 *                     System.out.println(queue.top());
 *                 }
 *                 if ("POP".equals(str)) {
 *                     int pop = queue.pop();
 *                     if (pop == -1) {
 *                         System.out.println(-1);
 *                     }
 *                 }
 *                 if ("SIZE".equals(str)) {
 *                     System.out.println(queue.getSize());
 *
 *                 }
 *
 *             }
 *         }
 *     }
 *
 *     private static class queue {
 *         int size;
 *         Node root;
 *
 *         public queue() {
 *             size = 0;
 *             root = new Node();
 *
 *         }
 *
 *         void push(int element) {
 *             size++;
 *             Node node = root;
 *             for (int i = 0; i < size - 1; i++) {
 *                 node = root.next;
 *             }
 *
 *             node.next = new Node(element);
 *
 *         }
 *
 *         void clear() {
 *             root.next = null;
 *             size = 0;
 *
 *         }
 *
 *
 *         int getSize() {
 *             return size;
 *         }
 *
 *         Integer top() {
 *             if ( root.next == null) {
 *                 return -1;
 *
 *             }
 *
 *             return root.next.element;
 *
 *         }
 *
 *         int pop() {
 *             if (root.next == null) return -1;
 *             root = root.next;
 *             size--;
 *             return 0;
 *         }
 *
 *
 *     }
 *
 *     private static class Node {
 *         Node next;
 *         int element;
 *
 *         public Node() {
 *         }
 *
 *         public Node(int element) {
 *             this.element = element;
 *         }
 *     }
 * }
 *
 */
