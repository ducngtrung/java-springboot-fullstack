package LeetCode_112_98;

import java.util.ArrayList;
import java.util.List;

// Given the root of a binary tree, determine if it is a valid binary search tree (BST).
// A valid BST is defined as follows:
//     The left subtree of a node contains only nodes with keys less than the node's key.
//     The right subtree of a node contains only nodes with keys greater than the node's key.
//     Both the left and right subtrees must also be binary search trees.

public class LeetCode_98 {
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n6 = new TreeNode(6);

        n5.left = n1; n5.right = n4;
        n4.left = n3; n4.right = n6;

        System.out.println(isValidBST(n5));
    }

    static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    static boolean isValidBST(TreeNode root, TreeNode left, TreeNode right){
        if (root == null) return true;
        if (left != null && left.val >= root.val) return false;
        if (right != null && right.val <= root.val) return false;        
        
        return isValidBST(root.left, left, root) 
            && isValidBST(root.right, root, right); 
    }

    // // Cách 2:
    // static List<Integer> nodeList = new ArrayList<>();
    // static boolean isValidBST(TreeNode root) {
    //     // Nếu đúng là Binary Search Tree thì sau khi duyệt inOrder sẽ trả về dãy số tăng dần
    //     inOrder(root);
    //     for(int i = 1; i < nodeList.size(); ++i) {
    //         if (nodeList.get(i) <= nodeList.get(i-1)) return false;
    //     }
    //     return true;
    // }

    // static void inOrder(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     // Duyệt bên trái
    //     inOrder(root.left);
    //     // Duyệt gốc
    //     nodeList.add(root.val);
    //     // Duyệt bên phải
    //     inOrder(root.right);
    // }
}