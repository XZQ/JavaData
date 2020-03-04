package com.xzq;


import com.xzq.queue.LoopQueue;
import com.xzq.queue.MyQueue;
import com.xzq.stack.ArrayStack;

import java.util.ArrayList;
import java.util.Deque;

//https://www.cnblogs.com/ysocean/tag/Java%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95/
//https://www.cnblogs.com/xiaoxiongcanguan/category/1416652.html
public class Test {
    public static void main(String[] args) {
//        ArrayStackTest();
//        testStringReversal();
//        testMatch();
//        testArray();
//        testMyQueue();
//        LoopQueue();

        ArrayList<String> stringArray = new ArrayList<>();
        stringArray.add("苹果");
        stringArray.add("香蕉");
        stringArray.add("番茄");
        System.out.println(stringArray.toString());

    }

    public static void LoopQueue() {
        LoopQueue queue = new LoopQueue(8);
        for (int i = 0; i < 8; i++) {
            queue.enqueue("I" + i);
        }
        System.out.println(queue.toString());
        queue.denqueue();
        queue.denqueue();
        System.out.println(queue.toString());
        queue.enqueue("XZQ");
        queue.enqueue("IBM");
        System.out.println(queue.toString());
        queue.denqueue();
        queue.denqueue();
        System.out.println(queue.toString());
        queue.enqueue("GOOGLE");
        queue.enqueue("Apple");
        System.out.println(queue.toString());
        queue.denqueue();
        System.out.println(queue.toString());
    }

    public static void testMyQueue() {

        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);//queArray数组数据为[1,2,3]

        System.out.println(queue.toString() + " " + queue.getFront()); //1
        queue.dequeue();//queArray数组数据为[null,2,3]
        System.out.println(queue.toString() + " " + queue.getFront()); //2
        queue.enqueue(4);//queArray数组数据为[4,2,3]
        queue.enqueue(5);//队列已满,queArray数组数据为[4,2,3]
        System.out.println(queue.toString() + " " + queue.getFront()); //2
    }

    public static void testArray() {
        Array array = new Array();
        for (int i = 0; i < 20; i++) {
            array.add(i, "i" + i);
        }
        for (int i = 0; i < 15; i++) {
            array.removeFirst();
            System.out.println("== " + array.toString());
        }


    }

    //分隔符匹配
//遇到左边分隔符了就push进栈，遇到右边分隔符了就pop出栈，看出栈的分隔符是否和这个有分隔符匹配
    public static void testMatch() {
        ArrayStack stack = new ArrayStack();
        String str = "12<a[b{c}]>";
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            switch (aChar) {
                case '<':
                case '[':
                case '{':
                    stack.push(aChar);
                    break;
                case '}':
                case ']':
                case '>':
                    if (!stack.isEmpty()) {
                        char ch = stack.pop().toString().toCharArray()[0];
                        if (aChar == '}' && ch != '{'
                                || aChar == ']' && ch != '['
                                || aChar == ')' && ch != '(') {
                            System.out.println("Error:" + ch + "-" + aChar);
                        }
                    }
                    break;
            }
        }
    }

    /**
     * 字符串反转
     */
    public static void testStringReversal() {
        ArrayStack stack = new ArrayStack();
        String str = "how are you";
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            stack.push(aChar);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public static void ArrayStackTest() {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push("abc");
//        System.out.println(stack.peek());.
        System.out.println(stack.toString());
    }
}
