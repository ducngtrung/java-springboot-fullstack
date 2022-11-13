package LeetCode_206;

// Given the head of a singly linked list.
// Reverse the list, and return the reversed list.

public class LeetCode_206 {
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        printNode(n1);

        ListNode nReverse = reverseList(n1);
        printNode(nReverse);
    }

    static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode reversListNode = new ListNode(head.val);
        while (head.next != null) { // Duyệt qua từng node cho đến node cuối cùng
            head = head.next; // Dịch head sang vị trí tiếp theo bên phải
            ListNode temp = new ListNode(head.val); // Gán biến temp = head ở vị trí mới
            temp.next = reversListNode; // Trỏ temp ngược lại về bên trái (reversListNode)
            reversListNode = temp; // Gán cho reversListNode bắt đầu từ temp
        }
        return reversListNode;
    }

    static void printNode(ListNode head) {
        if (head == null) {
            System.out.println("LinkedList empty");
        } else {
            ListNode temp = head;
            while (temp != null) {
                System.out.print(temp.val);
                temp = temp.next; // Gán temp = phần tử tiếp theo
                if (temp != null) { // Nếu phần tử tiếp theo không rỗng
                    System.out.print(" -> ");
                } else {
                    System.out.println();
                }
            }
        }
    }
}