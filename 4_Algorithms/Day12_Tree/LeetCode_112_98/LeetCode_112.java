package LeetCode_112_98;

// Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
// A leaf is a node with no children.

public class LeetCode_112 {
    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n41 = new TreeNode(4);
        TreeNode n11 = new TreeNode(11);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n8 = new TreeNode(8);
        TreeNode n13 = new TreeNode(13);
        TreeNode n42 = new TreeNode(4);
        TreeNode n1 = new TreeNode(1);

        n5.left = n41; n5.right = n8;
        n41.left = n11;
        n11.left = n7; n11.right = n2;
        n8.left = n13; n8.right = n42;
        n42.right = n1;

        System.out.println(hasPathSum(n5, 22));
    }

    static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        if ((root.left == null) && (root.right == null) && (targetSum - root.val == 0))
            return true;
        else
            return hasPathSum(root.left, targetSum - root.val) 
                || hasPathSum(root.right, targetSum - root.val);
    }
}