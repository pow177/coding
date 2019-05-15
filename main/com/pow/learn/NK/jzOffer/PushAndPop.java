package main.com.pow.learn.NK.jzOffer;
import java.util.*;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 *
 */
public class PushAndPop {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if(!stack1.isEmpty()){
            stack1.push(node);
        }else{
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
            stack1.push(node);
        }
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
