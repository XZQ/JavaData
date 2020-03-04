package com.company;

public class LinkedList<E> {

    private Node dummyHeader;//头结点
    private int size;//长度

    public LinkedList() {
        this.dummyHeader = new Node(null, null);
        this.size = 0;
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = header;
//        header = node;
//        header = new Node(e, header);
//        size++;
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("ADD Fil");
        }

        Node prev = dummyHeader;
        //找的添加位置的头结点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
//            prev.next = new Node(e, prev.next);
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get Fail");
        }
        Node cur = dummyHeader.next;
        for (int i = 0; i < index; i++) {
            cur = (Node) cur.next;
        }
        return (E) cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set Fail");
        }
        Node cur = dummyHeader.next;
        for (int i = 0; i < index; i++) {
            cur = (Node) cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHeader.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("set Fail");
        }
        Node prev = dummyHeader;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node cur = prev.next;
        prev.next = cur.next;
        cur.next = null;
        size--;
        return (E) cur.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        Node cur = dummyHeader.next;
//        while (cur != null) {
//            sb.append("cur -> " + cur);
//            cur = cur.next;
//        }
        for (Node cur = dummyHeader.next; cur != null; cur = cur.next) {
            sb.append("  cur -> " + cur);
        }
        sb.append(" NULL");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
