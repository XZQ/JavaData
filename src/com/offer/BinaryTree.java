package com.offer;

import com.binary.TreeNode;

import java.util.Arrays;

/**
 * @author XZQ
 * @date 2020/3/19 18:54
 */
public class BinaryTree {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] middle = {4, 7, 2, 1, 5, 3, 8, 6};


        System.out.println(reConstructBinaryTree(pre, middle));

    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] middle) {
        if (pre == null || pre.length == 0 || middle == null || middle.length == 0 || pre.length != middle.length) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);

        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == middle[i]) {//左子树
                treeNode.lchild = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(middle, 0, i));
                treeNode.rchild = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(middle, i + 1, middle.length));
            }
        }
        return treeNode;
    }
}
