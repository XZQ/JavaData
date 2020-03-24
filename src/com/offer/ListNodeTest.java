package com.offer;

/**
 * @author XZQ
 * @date 2020/3/24 10:40
 * https://www.cnblogs.com/qianguyihao/p/4782595.html
 * https://blog.csdn.net/agoodcoder777/article/details/89444836
 * https://blog.csdn.net/m0_37450089/article/details/79305256
 * https://blog.csdn.net/weixin_41445507/article/details/89074868?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
 */
public class ListNodeTest {

    public Node head;
    public Node current;//当前节点

    public static void main(String[] args) {
        ListNodeTest list = new ListNodeTest();
//        for (int i = 0; i < 4; i++) {
//            list.add(i);
//        }
//        System.out.println(mergeListNode(list.head, list1.head));

        testMergeListNode();

    }

    public static void testMergeListNode() {
        ListNodeTest list1 = new ListNodeTest();
        ListNodeTest list2 = new ListNodeTest();
        //向LinkList中添加数据
        for (int i = 0; i < 4; i++) {
            list1.add(i);
        }

        for (int i = 3; i < 8; i++) {
            list2.add(i);
        }

        ListNodeTest list3 = new ListNodeTest();
        list3.head = list3.mergeListNode(list1.head, list2.head); //将list1和list2合并，存放到list3中

        list3.print(list3.head);// 从head节点开始遍历输出

    }

    /**
     * 合并两个有序的单链表，合并之后的链表依然有序：
     */
    public static Node mergeListNode(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        //
        Node head; //新链表的头结点
        Node current;  //current结点指向新链表

        // 一开始，我们让current结点指向head1和head2中较小的数据，得到head结点
        if (head1.data < head2.data) {
            head = head1;
            current = head1;
            head1 = head1.next;
        } else {
            head = head2;
            current = head2;
            head2 = head2.next;
        }
        //比较合并
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;// //新链表中，current指针的下一个结点对应较小的那个数据
                current = current.next;//指针下移
                head1 = head1.next;
            } else {
                current.next = head2;
                current = current.next;
                head2 = head2.next;
            }
        }
        //合并剩余的元素
        //合并剩余的元素
        if (head1 != null) { //说明链表2遍历完了，是空的
            current.next = head1;
        }
        if (head2 != null) { //说明链表1遍历完了，是空的
            current.next = head2;
        }
        return head;
    }

    /**
     * 查找单链表中的中间结点
     * 和上面的第2节一样，也是设置两个指针first和second，只不过这里是，两个指针同时向前走，
     * second指针每次走两步，first指针每次走一步，直到second指针走到最后一个结点时，
     * 此时first指针所指的结点就是中间结点。注意链表为空，链表结点个数为1和2的情况。时间复杂度为O（n）。
     */
    public Object findCenter() {
        if (head == null) {
            return null;
        }
        Node first = head;
        Node second = head;
        //
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        //
        return first;
    }

    /**
     * 查找单链表中的倒数第k个结点
     */
    public Object findK(int k) {
        if (k < 0) {
            return null;
        }
        int length = getLength(head);
        //倒数第K个，即为 正数第（length - k）个
        int searchIndex = length - k;

        Node current = head;
        for (int i = 0; i < length; i++) {
            if (i == searchIndex) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * 查找单链表中的倒数第k个结点
     * <p>
     * 这里需要声明两个指针：即两个结点型的变量first和second，首先让first和second都指向第一个结点，
     * 然后让second结点往后挪k-1个位置，此时first和second就间隔了k-1个位置，然后整体向后移动这两个节点，
     * 直到second节点走到最后一个结点的时候，此时first节点所指向的位置就是倒数第k个节点的位置。时间复杂度为O（n）
     */
    public Object findKSC(int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        Node first = head;
        Node second = head;

        //让second结点往后挪index个位置
        for (int i = 0; i < k; i++) {
            second = second.next;
        }
        //同时移动first和second
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

    /**
     * 查找单链表中的倒数第k个结点
     * <p>
     * 如果k大于链表中节点个数时，就会报空指针异常，所以这里需要做一下判断。
     */
    public Object findKSC2(int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        Node first = head;
        Node second = head;

        //让second结点往后挪index个位置
        for (int i = 0; i < k; i++) {
            second = second.next;
            if (second == null) {
                return null;
            }
        }
        //同时移动first和second
        while (second != null) {
            first = first.next;
            second = second.next;
        }
        return first;
    }


    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            current = head;
        } else {
            current.next = new Node(data);
            current = current.next;
        }
    }

    //方法：获取单链表的长度
    public static int getLength(Node head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public void print(Node node) {
        if (node == null) {
            return;
        }
        current = node;
        while (current != null) {
            System.out.print(current.data +" ");
            current = current.next;
        }
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + '}';
        }
    }
}
