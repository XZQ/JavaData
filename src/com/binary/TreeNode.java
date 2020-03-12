package com.binary;

public class TreeNode<E> {

    /**
     * 数据域
     */
    public E data;

    /**
     * 左子树，右子树指针域
     */
    public TreeNode<E> lchild;
    public TreeNode<E> rchild;

    public TreeNode(E data) {
        this.data = data;
    }


    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TreeNode<?> treeNode = (TreeNode<?>) o;
        if (data != null ? !data.equals(treeNode.data) : treeNode.data != null) return false;
        if (lchild != null ? !lchild.equals(treeNode.lchild) : treeNode.lchild != null) return false;
        return rchild != null ? rchild.equals(treeNode.rchild) : treeNode.rchild == null;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (lchild != null ? lchild.hashCode() : 0);
        result = 31 * result + (rchild != null ? rchild.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", lchild=" + lchild +
                ", rchild=" + rchild +
                '}';
    }
}
 