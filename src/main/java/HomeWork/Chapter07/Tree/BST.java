package HomeWork.Chapter07.Tree;

import java.util.Comparator;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/4/3 0003 21:19
 */
public class BST<E> extends BinaryTree implements IBinarySearchTree<E> {
    Comparator<E> comparator;


    public BST(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public BST() {
        comparator = null;
    }


    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    public void add(E element) {
        if (root == null) {//添加第一个节点
            root = createNode(element, null);
            size++;
            afterAdd(root);
            return;
        }
        //添加的不是第一个节点
        //找到父节点
        Node<E> parent = null;
        Node<E> node = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node.element = element;
                return;//两个数字相同时
            }
        }
        //看看插入到父节点的哪个位置
        Node<E> newNode = createNode(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;
        afterAdd(newNode);

    }

    protected void afterAdd(Node<E> node) { }

    public void remove(E element) {
        remove(node(element));

    }

    private void remove(Node<E> node) {
        if (node==null) return;
        size--;
        //度为2的节点
        if (node.hasTwoChildren()) {
         //找到后继节点
            Node<E> p = successor(node);
            //用后继节点覆盖度为2的节点的值
            node.element = p.element;
            //删除后继节点
            node = p;//TODO 我认为不是很妥

        }
        //删除node节点(node的度必然是0或1)
        Node<E> replacement = node.left != null ? node.left : node.right;
        //node是度为1 的节点
        if (replacement != null) {
            //更改parent
            replacement.parent = node.parent;
            //更改parent的left、right指向
            if (node.parent != null) {
                root = replacement;
            } else if (node == node.parent.left) {
                node.parent.left = replacement;
            } else {// node = node.parent.right
                node.parent.right = replacement;
            }
        } else if (node.parent == null) {//node是叶子节点并且是根节点
            root = null;
        } else {//node是叶子节点，但不是根节点
            if (node == node.parent.left) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }

        }

    }

    private Node<E> node(E element) {
        Node<E> p = root;

        while (p != null) {
            int cmp = compare(element, p.element);
            if (cmp < 0) {
                p = p.left;
            }
            if (cmp==0) return p;
            if (cmp > 0) {
                p = p.right;
            }
        }
        return null;
    }

    public boolean contains(E element) {
        return node(element) != null;
    }

    private int compare(E e1, E e2) {
        if (comparator != null) {
           return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
    }


}
