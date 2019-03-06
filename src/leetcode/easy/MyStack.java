package easy;

import java.util.LinkedList;

/**
 * ****************************************
 * author：琚涛
 * time：2019/3/4
 * description：225. 用队列实现栈
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 * <p>
 * ****************************************
 */
public class MyStack {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(22);
        myStack.push(23);
        System.out.println(myStack.empty());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
    private LinkedList<Integer> linkedList;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        linkedList = new LinkedList();
    }

    /**
     * Push element x onto stack.
     * 元素 x 入栈
     */
    public void push(int x) {
        linkedList.push(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     * 移除栈顶元素
     */
    public int pop() {
        return linkedList.remove(0);
    }

    /**
     * Get the top element.
     * 获取栈顶元素
     */
    public int top() {
        return linkedList.get(0);
    }

    /**
     * Returns whether the stack is empty.
     * 返回栈是否为空
     */
    public boolean empty() {
        return linkedList.isEmpty();
    }
}
