package com.company;

public class Node {
    public Object e;//存储的元素
    public Node next;//下一个节点的指针

    public Node(Object e, Node next) {
        this.e = e;
        this.next = next;
    }

    public Node(Object e) {
        this(e, null);
    }

    public Node() {
        this(null, null);
    }

    @Override
    public String toString() {
        return "e=" + e;
    }
}