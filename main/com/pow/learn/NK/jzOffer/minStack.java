package main.com.pow.learn.NK.jzOffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * 思路：用两个栈，一个负责存储进栈的数，另外一个help栈，当进来的数比help栈顶小的话则入栈。
 * 出栈的时候如果该数是help的栈顶的数，同步出栈。这样就help栈维护了一个stack当前最小值的一个结构了。
 */
public class minStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> help = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if(help.isEmpty() ||(!help.isEmpty() && help.peek()>node)){
            help.push(node);
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int p = stack.pop();
        if(p==help.peek()){
            help.pop();
        }
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.pop();
    }

    public int min() {
        if(help.isEmpty()){
            return -1;
        }
        return help.peek();
    }
}
