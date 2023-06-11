package taest.leetcode;

import java.util.Stack;

public class MyQueue {

    private static Stack<Integer> inStack;
    private static Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        inToOut();
        return outStack.pop();
    }

    public int peek() {
        inToOut();
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }

    public void inToOut(){
        if (outStack.empty()){
            while (!inStack.empty()){
                outStack.push(inStack.pop());
            }
        }

    }
}
