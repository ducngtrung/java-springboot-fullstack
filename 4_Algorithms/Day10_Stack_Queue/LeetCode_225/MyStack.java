package LeetCode_225;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;

    // Constructor
    public MyStack() {
        queue = new ArrayDeque<>();
    }

    // Push element x onto stack
    public void push(int x) {
        queue.add(x);
        int n = queue.size();
        while (n > 1) {
            queue.add(queue.poll());
            --n;
        }
    }

    // Remove the element on top of the stack and return that element
    public int pop() {
        return queue.poll();
    }

    // Get the top element
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty
    public boolean empty() {
        return queue.isEmpty();
    }
}