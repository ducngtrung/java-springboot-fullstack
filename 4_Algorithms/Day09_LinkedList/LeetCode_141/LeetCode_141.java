package LeetCode_141;

import java.util.HashSet;
import java.util.Set;

// Given the head of a linked list, determine if the linked list has a cycle in it.
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
// Internally, "pos" is used to denote the index of the node that tail's "next" pointer is connected to.
// Return true if there is a cycle in the linked list. Otherwise, return false.

public class LeetCode_141 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        System.out.println(hasCycle(n1));
    }

    static boolean hasCycle(ListNode head) {
        ListNode temp = head;

        // Tạo set để lưu danh sách các node
        Set<ListNode> nodeSet = new HashSet<>();
        nodeSet.add(temp);

        while (temp != null) { // Duyệt từng node thông qua biến temp
            if (nodeSet.contains(temp.next)) {
                return true; // Nếu node hiện tại trỏ đến node kế tiếp đã tồn tại trong nodeSet thì return true
            } else {
                // Gán temp = node kế tiếp, sau đó add node đó vào nodeSet
                temp = temp.next;
                nodeSet.add(temp);
            } 
        }
        return false;
    }
}