package LeetCode_232;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    Deque<Integer> stackIn;
    Deque<Integer> stackOut;
    
    // Constructor
    public MyQueue() {
        stackIn = new ArrayDeque<>();
        stackOut = new ArrayDeque<>();    
    }
    
    // Push element x to the back of queue
    public void push(int x) {
        stackIn.push(x);
    }
    
    // Remove the element from in front of queue and return that element
    public int pop() {
        peek();
        return stackOut.pop();
    }
    
    // Get the front element
    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }
    
    // Return whether the queue is empty
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}