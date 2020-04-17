package HomeWork.Chapter07.Tree;

import HomeWork.Chapter07.Tree.Util.TreePrinter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/5 0005 22:44
 */
public class BinaryTree<E> {
    protected int size;
    Node<E> root;
    public Node<E> getRoot() {
        return root;
    }
    public int size() {
        return 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void clear() {
        size = 0;
        root = null;

    }
    /*
     * 中序遍历
     * 左根右
     * 因为是二叉搜索树，所以中序遍历为有序
     * */
    public void inOrderTraversal(Visitor<E> visitor) {
        inOrderTraversal(root,visitor);
    }
    private void inOrderTraversal(Node<E> node,Visitor<E> visitor) {
        if (visitor==null||node==null) return;
        inOrderTraversal(node.left,visitor);
        visitor.visit(node.element);
        inOrderTraversal(node.right,visitor);
    }
    /*
     * 前序遍历
     * 根左右
     * */
    public void preOrderTraversal(Visitor<E> visitor) {
        preOrderTraversal(root,visitor);
    }
    private void preOrderTraversal(Node<E> node,Visitor<E> visitor) {
        if (visitor==null||node==null) return;
        visitor.visit(node.element);
        preOrderTraversal(node.left,visitor);
        preOrderTraversal(node.right,visitor);
    }
    /*
     * 后序遍历
     * 左右根
     * */
    public void postOderTraversal(Visitor<E> visitor) {
        postOderTraversal(root,visitor);
    }
    private void postOderTraversal(Node<E> node,Visitor<E> visitor) {
        if (visitor==null||node==null) return;
        postOderTraversal(node.left,visitor);
        postOderTraversal(node.right,visitor);
        visitor.visit(node.element);
    }
    /*
     * 层序遍历
     *
     * */
    public void levelOrderTraversal(Visitor visitor) {
        if (root==null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            visitor.visit(node.element);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

        }
    }
    private Node<E> predecessor(Node<E> node) {
        if (node==null) return null;
        //前驱节点在左子树中
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        //从父节点，祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }
    protected Node<E> successor(Node<E> node) {
        if (node==null) return null;
        //前驱节点在左子树中
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }
        //从父节点，祖父节点中寻找前驱节点
        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    /*
     *
     * 计算高度
     * 递归
     * */
    public int height() {
        return height(root);
    }
    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));

    }
    public boolean isComplete() {
        if (root==null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (leaf && !node.isLeaf()) {
                return false;
            }
            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) {
                return false;
            }
            if (node.right != null) {
                queue.offer(node.right);
            } else {
                leaf = true;
            }

        }
        return true;
    }
    protected static class Node<E> implements TreePrinter.PrintableNode {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        @Override
        public String toString() {
            if (parent==null) return element+"";
            return element + "_P(" + parent.element + ")";
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
        }

        public boolean isLeftChild() {
            return parent != null && this == parent.left;
        }
        public boolean isRightChild() {
            return parent != null && this == parent.right;
        }


        @Override
        public TreePrinter.PrintableNode getLeft() {
            return left;
        }

        @Override
        public TreePrinter.PrintableNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return element.toString();
        }
    }
    public interface Visitor<E> {
        void visit(E element);
    }

    protected Node<E> createNode(E element, Node<E> parent) {
        return new Node<>(element, parent);
    }
}
