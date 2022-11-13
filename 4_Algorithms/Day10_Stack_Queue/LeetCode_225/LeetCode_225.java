package LeetCode_225;

// Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

// Implement the MyStack class with the following function:
//     void push(int x) Pushes element x to the top of the stack.
//     int pop() Removes the element on the top of the stack and returns it.
//     int top() Returns the element on the top of the stack.
//     boolean empty() Returns true if the stack is empty, false otherwise.

public class LeetCode_225 {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(3);
        obj.push(1);
        obj.push(4);
        obj.push(7);

        System.out.println(obj.pop());
        System.out.println(obj.top());
        System.out.println(obj.empty());
    }
}