package Design_a_binary_tree;

public class DesignBinaryTree {
    public static void main(String[] args) {
        // Khởi tạo cây tìm kiếm nhị phân (Binary Search Tree)
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        
        Node n6 = new Node(6);
        Node n3 = new Node(3);
        Node n1 = new Node(1);
        Node n4 = new Node(4);
        Node n9 = new Node(9);
        Node n8 = new Node(8);
        Node n7 = new Node(7);
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n12 = new Node(12);

        n6.left = n3; n6.right = n9;
        n3.left = n1; n3.right = n4;
        n9.left = n8; n9.right = n11;
        n8.left = n7;
        n11.left = n10; n11.right = n12;

        // Thêm Node vào Binary Search Tree
        binarySearchTree.insert(n6, 2);

        // Xóa Node khỏi Binary Search Tree
        binarySearchTree.remove(n6,9);

        // Duyệt Binary Search Tree
        binarySearchTree.preOrder(n6);
        System.out.println();
        binarySearchTree.inOrder(n6);
        System.out.println();
        binarySearchTree.postOrder(n6);
        System.out.println();
    }
}
