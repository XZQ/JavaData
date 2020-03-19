package com.offer;

import com.company.Node;

import java.util.Stack;

/**
 * @author XZQ
 * @date 2020/3/19 17:21
 */
public class ListNode {


    public static void main(String[] args) {
        Node node = new Node("1");
        Node node1 = new Node("2");
        Node node2 = new Node("3");
        Node node3 = new Node("4");
        Node node4 = new Node("5");
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        node.next = node1;
        System.out.println(node.toString());
        printListFromTailToHead(node);
    }

    public static void printListFromTailToHead(Node listNode) {
        Stack arrayStack = new Stack<>();
        while (listNode != null) {
            arrayStack.push(listNode.e);
            listNode = listNode.next;
        }
        while (!arrayStack.isEmpty()) {
            System.out.print(arrayStack.pop());
        }
    }

    public static void recursion(Node node) {
        if (node == null || node.next == null) {
            return;
        }
        recursion1(node);
    }

    private static void recursion1(Node node) {
        if (node != null) {
            if (node.next != null) {
                recursion1(node.next);
            }
            System.out.println(node.e);
        }
    }
}
