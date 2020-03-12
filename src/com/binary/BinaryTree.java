package com.binary;

/**
 * @author XZQ
 * @date 2020/3/12 19:06
 */

import java.util.*;

/**
 * 链式存储实现的二叉树
 */
public class BinaryTree<T> {

    /*
     * 树结点的个数
     */
    private int nodeCount;
    private TreeNode<T> rootNode;


    public BinaryTree(TreeNode<T> rootNode) {
        this.rootNode = rootNode;
        nodeCount = 1;
    }


    public BinaryTree() {
        this.rootNode = null;
        nodeCount = 0;
    }

    /**
     * 获得结点数
     *
     * @return
     */
    public int getNodeCount() {
        return nodeCount;
    }

    /**
     * 求树的高
     *
     * @return
     */
    public int height() {
        return depthForTree(rootNode);
    }

    /**
     * 求某棵子树的深度
     *
     * @param root
     * @return
     */
    private int depthForTree(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depthForTree(root.lchild), depthForTree(root.rchild)) + 1;
    }

    /**
     * 方法1
     * 由先序序列和中序序列构建二叉树
     */
    public TreeNode<T> createTreeByPreMidMethod1(T[] preArray, T[] midArray) {
        //递归出口，当有一者长度为空时，代表数组有误
        if (preArray.length == 0 || midArray.length == 0) {
            return null;
        }

        /**
         * 构建根结点
         * 如果根结点为空，则要设置根结点
         * 如果根结点已存在，则无需设置根结点
         */
        TreeNode<T> root = new TreeNode<>(preArray[0]);
        if (this.rootNode == null) {
            this.rootNode = root;
        }

        //遍历中序数组
        for (int i = 0; i < midArray.length; i++) {
            //在中序数组中找到根结点的索引位置，i虽然是索引，实际上代表(左子树的结点个数 - 1)
            if (root.data == midArray[i]) {
                /**
                 * 构建左子树
                 * 1. Arrays.copyOfRange是为了方便，[from,to)区间
                 * 2. 前序数组需要截取左子树的区间，作为新的子树前序数组
                 * 3. 中序数组需要截取左子树的区间，作为新的子树中序数组
                 */
                root.lchild = createTreeByPreMidMethod1(Arrays.copyOfRange(preArray, 1, 1 + i), Arrays.copyOfRange(midArray, 0, i));
                /**
                 * 构建右子树
                 * 1. Arrays.copyOfRange是为了方便，[from,to)区间
                 * 2. 前序数组需要截取右子树的区间，作为新的子树前序数组
                 * 3. 中序数组需要截取右子树的区间，作为新的子树中序数组
                 */
                root.rchild = createTreeByPreMidMethod1(Arrays.copyOfRange(preArray, i + 1, preArray.length), Arrays.copyOfRange(midArray, i + 1, midArray.length));
            }
        }

        //递归出口，正常构建，返回构建树的根结点
        return root;
    }

    /**
     * 根据前序和中序构建二叉树 | 标准
     * 1. 如果前序序列和中序序列为Null或长度为0，直接返回
     * 2. 如果前序序列和中序序列的长度不一致，则为错误序列，直接返回
     *
     * @param preArray
     * @param midArray
     * @return
     */
    public TreeNode<T> createTreeByPreMidMethod2(T[] preArray, T[] midArray) {
        if (preArray == null || preArray.length == 0
                || midArray == null || midArray.length == 0) {
            return null;
        }
        if (preArray.length != midArray.length) {
            return null;
        }

        return createTreeByPreMidMethod2(preArray, 0, preArray.length - 1, midArray, 0, midArray.length - 1);
    }

    /**
     * 构建子树二叉树，根据前序和中序序列
     * 1. 通过前序序列，得知根结点
     * 2. 通过中序序列，比较根结点，得到根节点在中序序列的位置，就可以知道，左子树结点的个数，以及右子树结点的个数
     * 3. 然后递归求左子树和右子树
     *
     * @param preArray
     * @param preStart
     * @param preEnd
     * @param midArray
     * @param midStart
     * @param midEnd
     * @return
     */
    private TreeNode<T> createTreeByPreMidMethod2(T[] preArray, int preStart, int preEnd, T[] midArray, int midStart, int midEnd) {

        //递归退出条件一
        if (midStart > midEnd || preStart > preEnd) {
            return null;
        }

        //获得该树的根结点
        TreeNode<T> root = new TreeNode<>(preArray[preStart]);
        if (rootNode == null) {
            rootNode = root;
        }

        for (int i = midStart; i <= midEnd; i++) {
            if (root.data == midArray[i]) {
                /**
                 * 求左子树
                 * 左子树前序序列是从[preStart + 1,preStart到i - midStart个长度]，为什么是i - midStart?
                 * 我们知道从前序看，preStart + 1就是左子树的根节点，而这个左子树的长度是多少呢？就要从中序看，根节点左边的所有都是左子树结点，有多少个呢？就是 （i - midStart）个
                 * （i刚好就是根结点，但因为i是索引，如果索引是从0开始算，那么左子树结点就刚好是i个，如果不是从0开始，而是从某个索引a开始，那么i - a才能得到左子树结点真实的个数）
                 *
                 */
                root.lchild = createTreeByPreMidMethod2(preArray, preStart + 1, preStart + (i - midStart), midArray, 0, i - 1);

                /**
                 * 求右子树
                 */
                root.rchild = createTreeByPreMidMethod2(preArray, preStart + i - midStart + 1, preEnd, midArray, i + 1, midEnd);
            }
        }

        return root;


    }

    /**
     * 为某个结点添加左孩子
     *
     * @param lchild
     * @param parent
     * @return
     */
    public TreeNode<T> addLChild(TreeNode<T> lchild, TreeNode<T> parent) {
        if (parent.lchild == null) {
            parent.lchild = lchild;
            nodeCount++;
            return lchild;
        }
        throw new RuntimeException("该结点已存在左子结点");

    }


    /**
     * 为某个结点添加右孩子
     *
     * @param rchild
     * @param parent
     * @return
     */
    public TreeNode<T> addRChild(TreeNode<T> rchild, TreeNode<T> parent) {
        if (parent.rchild == null) {
            parent.rchild = rchild;
            nodeCount++;
            return rchild;
        }
        throw new RuntimeException("该结点已存在右子结点");

    }


    /**
     * 查找某个结点的孩子结点
     *
     * @param node
     * @return
     */
    public List<TreeNode<T>> listChildNode(TreeNode<T> node) {
        List<TreeNode<T>> childrens = new LinkedList<>();
        if (node.lchild != null) {
            childrens.add(node.lchild);
        }
        if (node.rchild != null) {
            childrens.add(node.rchild);
        }
        return childrens;

    }

    /**
     * 查找某个结点的父结点
     *
     * @param node
     * @return
     */
    public TreeNode<T> getParentNode(TreeNode<T> node) {
        if (node == null) {
            throw new RuntimeException("error");
        }
        return getParentNode(rootNode, node);
    }

    /**
     * 查找子树中，某个结点的父结点
     *
     * @param root
     * @param node
     * @return
     */
    private TreeNode<T> getParentNode(TreeNode<T> root, TreeNode<T> node) {
        //当前结点为null， 直接返回，函数出口
        if (root == null) {
            return null;
        }

        //当前结点的左孩子或右孩子是目标节点，则代表当前结点是目标结点的父结点，函数出口
        if (root.lchild == node || root.rchild == node) {
            return root;
        }

        //否则递归，先递归左子树
        TreeNode<T> result = getParentNode(root.lchild, node);
        //如果左递归没有发现符合条件，既result == null时，才开始右递归，如果已经发现了就不右递归了，直接返回结果
        if (result == null) {
            result = getParentNode(root.rchild, node);
        }


        return result;


    }


    /**
     * 先序遍历 | 递归
     */
    public void preOrder() {
        preOrder(rootNode);
        System.out.println();
    }

    /**
     * 先序遍历以node为根结点的树
     *
     * @param node
     */
    private void preOrder(TreeNode<T> node) {
        // 若二叉树不为空
        if (node != null) {
            System.out.print(node.data);// 访问当前结点
            preOrder(node.lchild);// 按先跟次序遍历当前结点的左子树
            preOrder(node.rchild);// 按先跟次序遍历当前结点的右子树
        }
    }

    /**
     * 中序遍历 | 递归
     */
    public void midOrder() {
        midOrder(rootNode);
        System.out.println();
    }

    /**
     * 对node为根节点的子树进行中序遍历
     *
     * @param node
     */
    private void midOrder(TreeNode<T> node) {
        if (node != null) {
            midOrder(node.lchild);
            System.out.print(node.data);
            midOrder(node.rchild);
        }
    }

    /**
     * 后序遍历 | 递归
     */
    public void postOrder() {
        postOrder(rootNode);
        System.out.println();
    }

    /**
     * 对以node为根结点的子树进行后序遍历
     *
     * @param node
     */
    private void postOrder(TreeNode<T> node) {
        if (node != null) {
            postOrder(node.lchild);
            postOrder(node.rchild);
            System.out.print(node.data);
        }
    }


    /**
     * 先序遍历 | 循环 | 栈实现 |  先进后出
     * <p>
     * 1. 每次循环相当于访问一棵子树
     * 2. 每次访问子树都要根据某序遍历的规则进行访问
     * 3. 栈用来存储之前访问过的结点的，用于回溯
     * 4. 首先条件就是要相对根结点不为空，已经用于回溯的栈不为空，如果都为空，肯定代表遍历已结束
     * 5. 从根结点找，遍历子树，一直找下去，遍历一个结点输出一个，同时用栈记录下来，用于回溯
     * 6. 当找到一个结点为空，则回溯结点，找其右子树
     */
    public void preOrderIteration() {
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        TreeNode<T> root = this.rootNode;

        //结点不为空，或者栈不为空，如果两者都是空，则遍历完毕
        while (root != null || !stack.isEmpty()) {
            //如果相对根结点不为空，有下一步，不需要回溯
            if (root != null) {
                //则先序输出根结点
                System.out.print(root.data);
                //将结点入栈
                stack.push(root);
                //遍历当前结点的左子结点
                root = root.lchild;
            } else {
                //如果相对根结点为空 | 或者当前结点为空，没有可行下一步了，需要回溯
                //出栈获得上一个结点
                root = stack.pop();
                //则找上一个结点右子树
                root = root.rchild;
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历 | 循环 | 栈实现 |  先进后出
     * <p>
     * 1. 中序就是回溯时再输出
     */
    public void midOrderIteration() {
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        TreeNode<T> root = this.rootNode;

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.lchild;
            } else {
                root = stack.pop();
                System.out.print(root.data);
                root = root.rchild;
            }
        }
        System.out.println();


    }

    /**
     * 后序遍历 | 循环 | 栈实现 | 先进后出
     * <p>
     * 1. 这个后序的实现非常巧妙特别，后序实际是逆前序的实现，我们知道前序是根->左->右；后序是左->后->根。但后序其实还可以这么思考，既根->右->左，得到的就是后序的逆序，这根右左就非常像前序遍历了
     * 2. 模拟前序遍历一样的逻辑，只不过与前序不同的是，先右再左，所以当node != null时，把访问结点存储到stack中，用于回溯，同时记录到output中，用于倒序输出
     * 3. 其他跟前序是一样的，只不过后序是根右左的倒序罢了，所以需要一个栈用来存储，并倒序输出
     */
    private void postOrderIteration() {
        if (rootNode == null) {
            return;
        }
        Deque<TreeNode<T>> stack = new ArrayDeque<>();
        Deque<TreeNode<T>> output = new ArrayDeque<>();
        TreeNode<T> node = rootNode;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                output.push(node);
                node = node.rchild;
            } else {
                node = stack.pop();
                node = node.lchild;
            }
        }
        while (!output.isEmpty()) {
            System.out.print(output.pop().data);
        }
        System.out.println();
    }


    /**
     * 层次遍历 | 循环 | 队列实现 | 先进先出
     * 1. 层次遍历就是从第一层开始到最底层，从每层的左边到右边遍历
     * 2. 利用队列的先进先出特性，树的所有结点都会进入队列，除了根结点
     * 3. 首先结点不为空，我们就继续遍历，因为node的除了是根结点，就是队列中存储的树的其他结点，不可能为空，当空时，就代表队列已经出队完毕
     * 4. 每次循环就是遍历某个结点左右孩子的过程，遍历结束后，需要出队一个结点，作为下次遍历的结点
     */
    public void levelOrder() {
        Deque<TreeNode<T>> queue = new LinkedList<>();
        TreeNode<T> root = this.rootNode;
        while (root != null) {
            System.out.print(root.data);
            if (root.lchild != null) {
                // 相对根结点的左孩子结点入队
                queue.offer(root.lchild);
            }
            if (root.rchild != null) {
                // 相对根结点的右孩子结点入队
                queue.offer(root.rchild);
            }
            //队列队头出队，相对根结点指向出队结点 ,若队列空返回null
            root = queue.poll();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(2);
        TreeNode<Integer> node3 = new TreeNode<>(3);
        TreeNode<Integer> node4 = new TreeNode<>(4);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node6 = new TreeNode<>(6);
        TreeNode<Integer> node7 = new TreeNode<>(7);
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        /* binaryTree.createTreeByPreMid(new Integer[]{1, 2, 4, 5, 3, 6, 7}, new Integer[]{4, 2, 5, 1, 6, 3, 7});*/
        binaryTree.createTreeByPreMidMethod2(new Integer[]{1, 2, 4, 5, 3, 6, 7}, new Integer[]{4, 2, 5, 1, 6, 3, 7});

      /*  binaryTree.addLChild(node2, node1);
        binaryTree.addRChild(node3, node1);
        binaryTree.addLChild(node4, node2);
        binaryTree.addRChild(node5, node2);
        binaryTree.addLChild(node6, node3);
        binaryTree.addRChild(node7, node3);*/
        System.out.println("递归");
        binaryTree.preOrder();
        binaryTree.midOrder();
        binaryTree.postOrder();
        System.out.println("循环|栈实现");
        binaryTree.preOrderIteration();
        binaryTree.midOrderIteration();
        binaryTree.postOrderIteration();
        binaryTree.levelOrder();

    }


}
