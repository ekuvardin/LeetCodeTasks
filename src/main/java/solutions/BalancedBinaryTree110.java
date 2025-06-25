package solutions;

/*
yandex

 BalancedBinaryTree110.TreeNode l1 = new BalancedBinaryTree110.TreeNode(1);
        BalancedBinaryTree110.TreeNode l2 = new BalancedBinaryTree110.TreeNode(2);
        BalancedBinaryTree110.TreeNode l3 = new BalancedBinaryTree110.TreeNode(2);
        BalancedBinaryTree110.TreeNode l4 = new BalancedBinaryTree110.TreeNode(3);
        BalancedBinaryTree110.TreeNode l5 = new BalancedBinaryTree110.TreeNode(3);
        BalancedBinaryTree110.TreeNode l6 = new BalancedBinaryTree110.TreeNode(4);
        BalancedBinaryTree110.TreeNode l7 = new BalancedBinaryTree110.TreeNode(4);

        l1.left = l2;
        l1.right = l3;
        l2.left = l4;
        l3.right = l5;
        l4.left = l6;
        l5.right = l7;


        BalancedBinaryTree110 l = new BalancedBinaryTree110();
        l.isBalanced(l1);
 */
public class BalancedBinaryTree110 {

    public boolean isBalanced(TreeNode root) {
        Balanced balanced = new Balanced();
        getNodeHeight(root, balanced);
        return balanced.isBalanced;
    }

    public int getNodeHeight(TreeNode node, Balanced isBalanced) {
        if (node == null || !isBalanced.isBalanced) {
            return 0;
        }

        int leftHeight = getNodeHeight(node.left, isBalanced);
        int rightHeight = getNodeHeight(node.right, isBalanced);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced.isBalanced = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static class Balanced {
        boolean isBalanced = true;
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
