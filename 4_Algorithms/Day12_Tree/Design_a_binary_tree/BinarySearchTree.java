package Design_a_binary_tree;

public class BinarySearchTree {
    
    // Thêm Node vào Binary Search Tree
    public Node insert(Node rootNode, int key) {
        Node newNode = new Node(key);
        if (rootNode == null) {
            return newNode;
        } else {
            Node temp = rootNode;
            while (true) {
                if (key < temp.value) { // Đi về bên trái
                    if (temp.left == null) {
                        temp.left = newNode;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else if (key > temp.value) { // Đi về bên phải
                    if (temp.right == null) {
                        temp.right = newNode;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
            return rootNode;
        }
    }

    // Xóa Node khỏi Binary Search Tree 
    public Node remove(Node rootNode, int key) {
        if (rootNode == null) {
            return null;
        }

        // Tìm node cần xóa
        Node temp = rootNode;
        if (key < temp.value) { // Đi về bên trái
            temp.left = remove(temp.left, key);
        } else if (key > temp.value) { // Đi về bên phải
            temp.right = remove(temp.right, key);
        } else {
            // TH1: Node cần xóa là node lá (have no child node)
            if (temp.left == null && temp.right == null) {
                return null;
            }
            // TH2: Node cần xóa có 1 node con (having only 1 child node)
            if (temp.left != null && temp.right == null) { // Node con nằm bên trái
                return temp.left;
            }
            if (temp.left == null && temp.right != null) { // Node con nằm bên phải
                return temp.right;
            }
            // TH3: Node cần xóa có 2 node con (having 2 child nodes)
            Node leftmostNode = findLeftNode(temp.right);
            temp.value = leftmostNode.value; // Thay thế Node cần xóa bằng Node trái cùng của cây con bên phải
            temp.right = remove(temp.right, leftmostNode.value);
        }
        return rootNode;
    }

    // Tìm Node trái cùng (ngoài cùng bên trái) của cây con
    private Node findLeftNode(Node rootNode) {
        if (rootNode == null) {
            return null;
        }
        
        Node findNode = rootNode;
        while (findNode.left != null) {
            findNode = findNode.left;
        }
        return findNode;
    }

    public void preOrder(Node root) {
        if (root == null) {
            return;
        }
        // Duyệt gốc
        System.out.print(root.value + "\t");
        // Duyệt bên trái
        preOrder(root.left);
        // Duyệt bên phải
        preOrder(root.right);
    }

    public void inOrder(Node root) {
        if (root == null) {
            return;
        }
        // Duyệt bên trái
        inOrder(root.left);
        // Duyệt gốc
        System.out.print(root.value + "\t");
        // Duyệt bên phải
        inOrder(root.right);
    }

    public void postOrder(Node root) {
        if (root == null) {
            return;
        }
        // Duyệt bên trái
        postOrder(root.left);
        // Duyệt bên phải
        postOrder(root.right);
        // Duyệt gốc
        System.out.print(root.value + "\t");
    }
}