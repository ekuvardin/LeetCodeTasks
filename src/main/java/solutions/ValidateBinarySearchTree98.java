package solutions;

/*

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

    The left

of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Yandex

        ValidateBinarySearchTree98.TreeNode l1 = new ValidateBinarySearchTree98.TreeNode(3);
        ValidateBinarySearchTree98.TreeNode l2 = new ValidateBinarySearchTree98.TreeNode(1);
        ValidateBinarySearchTree98.TreeNode l3 = new ValidateBinarySearchTree98.TreeNode(0);
        ValidateBinarySearchTree98.TreeNode l4 = new ValidateBinarySearchTree98.TreeNode(2);
        ValidateBinarySearchTree98.TreeNode l5 = new ValidateBinarySearchTree98.TreeNode(5);
        ValidateBinarySearchTree98.TreeNode l6 = new ValidateBinarySearchTree98.TreeNode(4);
        ValidateBinarySearchTree98.TreeNode l7 = new ValidateBinarySearchTree98.TreeNode(6);
        l1.left = l2;
        l2.left = l3;
        l2.right = l4;

        l1.right = l5;
        l5.left = l6;
        l5.right = l7;

 */
public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        return validRoot(root);
    }

    public boolean validRoot(TreeNode node) {
        if (node.left != null && node.left.val >= node.val) {
            return false;
        }

        if (node.right != null && node.right.val <= node.val) {
            return false;
        }

        return validLeft(node.left, null, node.val) && validRight(node.right, node.val, null);
    }


    public boolean validLeft(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if (node.left != null && (node.left.val >= node.val || (min != null && node.left.val <= min))) {
            return false;
        }

        if (node.right != null && (node.right.val <= node.val || node.right.val >= max)) {
            return false;
        }

        return validLeft(node.left, min, node.val) && validRight(node.right, node.val, max);
    }

    public boolean validRight(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if (node.left != null && (node.left.val >= node.val || node.left.val <= min)) {
            return false;
        }

        if (node.right != null && (node.right.val <= node.val || (max != null && node.right.val >= max))) {
            return false;
        }

        return validLeft(node.left, min, node.val) && validRight(node.right, node.val, max);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
