package test.blubridge;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-10-16 22:35
 */
public class BST {
    static class Node {
        int weight;
        Node father;
        Node left;
        Node right;

    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        int K = reader.nextInt();
        HashMap<Integer, Node> map = new HashMap<>();
        map.put(0, new Node());
        for (int i = 1; i <= N; i++) {
            map.put(i, new Node());
        }
        for (int i = 1; i <= N; i++) {
            Node cur = map.get(i);
            int P = reader.nextInt();
            int W = reader.nextInt();
            cur.father = map.get(P);
            cur.weight = W;

        }
        for (int i = 1; i <= N; i++) {
            Node cur = map.get(i);
            Node father = cur.father;
            if (cur.weight < father.weight) {
                father.left = cur;
            } else {
                father.right = cur;
            }
        }
        Node node = map.get(K);
        if (node.left != null && node.right != null) {
            System.out.println(0);
        } else {
            Node farther = node.father;
            //往左插入
            if (node.right != null) {
                //node是右节点
                if (node == farther.right) {
                    //大于父节点小于本节点
                    System.out.println(node.weight-farther.weight-1);
                }
                //node是左节点
                if (node == farther.left) {
                    //无限制
                    System.out.println(-1);
                }
            }
            //往右插入
            if (node.left != null) {
                //node是左节点
                if (node == farther.left) {
                    //小于父节点
                    //大于node
                    System.out.println(farther.weight-node.weight-1);
                }
                //node是右节点
                if (node == farther.right) {
                    //无限制
                    System.out.println(-1);

                }
            }
        }


    }
}
