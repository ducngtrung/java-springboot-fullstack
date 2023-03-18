import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AboutQueue {
    public static void main(String[] args) {
        // Queue
        Queue<Integer> queue = new LinkedList<>();
        
        // Thêm phần tử vào queue (First in, First out)
        queue.add(2);
        queue.add(1);
        queue.add(7);
        queue.add(9);
        System.out.println(queue);

        System.out.println("Lấy ra phần tử đầu tiên và xóa phần tử đó: " + queue.poll());
        System.out.println(queue);
        System.out.println("Lấy ra phần tử đầu tiên: " + queue.peek());


        // PriorityQueue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 5; i >= 0; --i) {
            priorityQueue.add(i);
        }
        System.out.println(priorityQueue);

        System.out.println("Lấy ra phần tử đầu tiên và xóa phần tử đó: " + priorityQueue.poll());
        System.out.println(priorityQueue);

        // Sắp xếp lại các phần tử trong priorityQueue
        List<Integer> list = new ArrayList<>();
        int size = priorityQueue.size();
        for (int i = 0; i < size; ++i) {
            list.add(priorityQueue.poll());
        }
        System.out.println(list);


        // Deque
        Deque<Integer> deque = new ArrayDeque<>();
        
        // Thêm phần tử vào dequeue (có thể thao thác từ cả 2 đầu của dequeue)
        deque.add(5);
        deque.add(6);
        deque.add(9);
        deque.addFirst(10);
        deque.addLast(1);
        System.out.println(deque);

        System.out.println("Lấy ra phần tử đầu tiên: " + deque.peekFirst());
        System.out.println("Lấy ra phần tử cuối cùng: " + deque.peekLast());
    }
}