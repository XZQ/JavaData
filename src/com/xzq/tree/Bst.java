package com.xzq.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Bst<E extends Comparable<E>> {


    private Node root;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(E e) {
        root = put(root, e);
    }

    private Node put(Node root, E e) {
        if (root == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(root.e) < 0) {
            root.left = put(root.left, e);
        } else if (e.compareTo(root.e) > 0) {
            root.right = put(root.right, e);
        } else {

        }
        return root;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder() {
        preOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 二分搜索树的层序遍历
    public void levelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
    }


    public E minNum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minNum(root).e;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minNum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minNum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin() {
        E e = minNum();
        root = removeMin(root);
        return e;
    }

    private Node removeMin(Node root) {
        if (root.left == null) {
            Node right = root.right;
            root.right = null;
            size--;
            return right;
        }
        root.left = removeMin(root.left);
        return root;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node root, E e) {
        if (root == null) {
            return root;
        }
         if (e.compareTo(root.e) < 0) { //左子树
            root.left = remove(root.left, e);
            return root;
        } else if (e.compareTo(root.e) > 0) {    //右子树
            root.right = remove(root.right, e);
            return root;
        } else {// e.compareTo(root.e)==0
            //待删除元素，左节点为空
            if (root.left == null) {
                Node right = root.right;
                root.right = null;
                size--;
                return right;
            }
            //待删除元素，右节点为空
            if (root.right == null) {
                Node left = root.left;
                root.left = null;
                size--;
                return left;
            }
            //待删除元素，左右节点不为空
            Node suc = minNum(root.right);//1 找到右节点的最小值
            suc.right = removeMin(suc);//2 删除右节点的最小值
            suc.left = root.left;//
            root.left = null;
            root.right = null;
            return suc;
        }

    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return true;
        }
    }


    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    private void add(Node root, E e) {
        if (root.e.equals(e)) {
            return;
        } else if (e.compareTo(root.e) < 0 && root.left == null) {
            root.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(root.e) > 0 && root.right == null) {
            root.right = new Node(e);
            size++;
            return;
        }
        if (e.compareTo(root.e) < 0) {
            add(root.left, e);
        } else {
            add(root.right, e);
        }
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }


    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
        }
    }
}
