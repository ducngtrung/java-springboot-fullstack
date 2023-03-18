package Design_a_linked_list;

public class DesignLinkedList {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        printNode(n1);
        printNode(n2);

        // Chèn 1 node vào đầu danh sách
        Node n0 = addAtHead(0, n1);
        printNode(n0);

        // Chèn 1 node vào cuối danh sách
        Node n4 = addAtTail(4, n0);
        printNode(n0);

        // Chèn 1 node vào giữa danh sách (ngay sau index 2)
        Node n5 = addAtIndex(5, 3, n0);
        printNode(n0);
    }

    static void printNode(Node headNode) {
        if (headNode == null) {
            System.out.println("LinkedList empty");
        } else {
            Node temp = headNode;
            while (temp != null) {
                System.out.print(temp.value);
                temp = temp.next; // Gán temp = phần tử tiếp theo
                if (temp != null) { // Nếu phần tử tiếp theo không rỗng
                    System.out.print(" -> ");
                } else {
                    System.out.println();
                }
            }
        }
    }

    static Node addAtHead(int value, Node headNode) {
        Node newNode = new Node(value);
        if (headNode != null) {
            newNode.next = headNode;
        }
        return newNode;
    }

    static Node addAtTail(int value, Node headNode) {
        Node newNode = new Node(value);
        if (headNode == null) {
            return newNode;
        } else {
            Node lastNode = headNode;
            // Duyệt qua từng node cho đến node cuối cùng 
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        return newNode;
    }

    static Node addAtIndex(int value, int index, Node headNode) {
        Node newNode = new Node(value);
        if (index == 0) {
            return addAtHead(value, headNode);
        } else {
            Node temp = headNode;
            int count = 0;
            while (temp != null) {
                ++count;
                if (count == index) {
                    newNode.next = temp.next; // link newNode với node liền sau (ở vị trí ngay sau index)
                    temp.next = newNode; // link newNode với node liền trước (ở vị trí index)
                    break;
                }
                temp = temp.next;
            }
        }
        return newNode;
    }
}