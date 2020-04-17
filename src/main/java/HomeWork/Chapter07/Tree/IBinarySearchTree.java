package HomeWork.Chapter07.Tree;

public interface IBinarySearchTree<E> {

    int size(); //元素的数量

    boolean isEmpty(); //是否为空

    void clear(); //清空所有元素

    void add(E element); //添加元素

    void remove(E element); //删除元素

    boolean contains(E element);//是否包含元素

    void preOrderTraversal(BST.Visitor<E> visitor);// 前序遍历

    void inOrderTraversal(BST.Visitor<E> visitor);//中序遍历

    void postOderTraversal(BST.Visitor<E> visitor);//后序遍历

    void levelOrderTraversal(BST.Visitor<E> visitor);//层序遍历

    int height();//获得高度

    boolean isComplete();// 判断是否为完全二叉树



}
