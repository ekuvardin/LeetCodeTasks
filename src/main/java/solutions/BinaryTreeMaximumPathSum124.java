package solutions;

/*
A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path.



Example 1:

Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

Example 2:

Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.



Constraints:

    The number of nodes in the tree is in the range [1, 3 * 104].
    -1000 <= Node.val <= 1000



yandex

     BinaryTreeMaximumPathSum124 l = new BinaryTreeMaximumPathSum124();

        BinaryTreeMaximumPathSum124.TreeNode l1 = new BinaryTreeMaximumPathSum124.TreeNode(5);
        BinaryTreeMaximumPathSum124.TreeNode l2 = new BinaryTreeMaximumPathSum124.TreeNode(4);
        BinaryTreeMaximumPathSum124.TreeNode l3 = new BinaryTreeMaximumPathSum124.TreeNode(8);
        BinaryTreeMaximumPathSum124.TreeNode l4 = new BinaryTreeMaximumPathSum124.TreeNode(11);
        BinaryTreeMaximumPathSum124.TreeNode l5 = new BinaryTreeMaximumPathSum124.TreeNode(7);
        BinaryTreeMaximumPathSum124.TreeNode l6 = new BinaryTreeMaximumPathSum124.TreeNode(2);

        BinaryTreeMaximumPathSum124.TreeNode l8 = new BinaryTreeMaximumPathSum124.TreeNode(13);
        BinaryTreeMaximumPathSum124.TreeNode l9 = new BinaryTreeMaximumPathSum124.TreeNode(4);
        BinaryTreeMaximumPathSum124.TreeNode l10 = new BinaryTreeMaximumPathSum124.TreeNode(1);

        l1.left = l2;
        l1.right = l3;

        l2.left = l4;

        l4.left = l5;
        l4.right = l6;

        l3.left = l8;
        l3.right = l9;

        l9.right = l10;

        l.maxPathSum(l1);
 */
public class BinaryTreeMaximumPathSum124 {

    int maxCount = -1001;

    public int maxPathSum(TreeNode root) {
        maxCount = -1001;
        calcPath(root);

        return maxCount;
    }

    public int calcPath(TreeNode root) {
        int left = -1001;
        int right = -1001;

        if (root.right == null && root.left == null) {
            maxCount = Math.max(maxCount, root.val);
            return root.val;
        }

        if (root.left != null) {
            left = calcPath(root.left);
        }

        if (root.right != null) {
            right = calcPath(root.right);
        }

        int nodeMaxValue = 0;
        //Math.max(right, left, root.val, right + root.val, left + root.val, left + right + root.val);

        int nodePathUp = 0;

        int nodesMaxPath = Math.max(right, left);
        if (nodesMaxPath <= 0) {
            nodeMaxValue = root.val;
            nodePathUp = nodeMaxValue;
        } else {
            int nodesMinPath = Math.min(right, left);
            if (nodesMinPath <= 0) {
                nodeMaxValue = nodesMaxPath + root.val;
            } else {
                nodeMaxValue = right + left + root.val;
            }
            nodePathUp = root.val + nodesMaxPath;
        }

        maxCount = Math.max(maxCount, nodeMaxValue);
        return nodePathUp;
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
