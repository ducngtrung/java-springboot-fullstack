package LeetCode_232;

// Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

// Implement the MyQueue class with the following function:
//     void push(int x) Pushes element x to the back of the queue.
//     int pop() Removes the element from the front of the queue and returns it.
//     int peek() Returns the element at the front of the queue.
//     boolean empty() Returns true if the queue is empty, false otherwise.

public class LeetCode_232 {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(3);
        obj.push(1);
        obj.push(4);
        obj.push(7);

        System.out.println(obj.pop());
        System.out.println(obj.peek());
        System.out.println(obj.empty());
    }
}