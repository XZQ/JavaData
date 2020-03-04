package com.xzq.node;

public class LinkedList<T> {

    public Node dummyHead;
    public int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(int index, T t) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(t, prev.next);
        size++;
    }

    public void addFirst(T t) {
        add(0, t);
    }

    public void addLast(T t) {
        add(size, t);
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.t;
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    public void set(int index, T t) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.t = t;
    }

    public boolean contains(T t) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.t.equals(t)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;//需要删除的元素
        prev.next = retNode.next;//指向下一个元素
        retNode.next = null;
        size--;
        return retNode.t;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public T removeFirst() {
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public T removeLast() {
        return remove(size - 1);
    }

    public void remove(T t) {
        Node cur = dummyHead;
        while (cur.next != null) {
            if (cur.t.equals(t)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            sb.append(cur + "------>");
        }
        sb.append("Null");
        return sb.toString();
    }

    private class Node {
        public T t;
        public Node next;

        public Node(T t, Node node) {
            this.t = t;
            this.next = node;
        }

        public Node(T t) {
            this(t, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "T=" + t;
        }
    }
}
