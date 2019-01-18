package easy;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/18
 * description：155. 最小栈
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * ****************************************
 */
public class MinStack {
    private Stack<Integer> stack;
    private PriorityQueue<Integer> queue;

    public MinStack() {
        stack = new Stack<>();
        queue = new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        queue.offer(x);
    }

    public void pop() {
        int pop=stack.pop();
        if(pop==queue.peek()){
            queue.poll();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return queue.peek();
    }
}
