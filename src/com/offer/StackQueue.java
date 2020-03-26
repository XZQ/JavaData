package com.offer;


import java.util.Stack;

/**
 * @author XZQ
 * @date 2020/3/26 10:16
 * <p>
 * 用两个栈来实现一个队列，完成队列的Push 和Pop 操作。队列中的
 * 元素为int 类型。
 */
public class StackQueue {

    Stack stack = new Stack<>();
    Stack stack1 = new Stack<>();

    public static void main(String[] args) {

    }

    public void push(Object object) {
        stack.push(object);
    }

    public Object pop() throws Exception {
        if (stack.empty() && stack1.empty()) {
            throw new Exception("栈为空！");
        }
        if (stack1.empty()) {
            while (!stack.empty()) {
                stack1.push(stack.pop());
            }
        }
        return stack1.pop();
    }

}
