package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
yandex

PathSumII113.TreeNode l1 = new PathSumII113.TreeNode(5);
        PathSumII113.TreeNode l2 = new PathSumII113.TreeNode(4);
        PathSumII113.TreeNode l3 = new PathSumII113.TreeNode(11);
        PathSumII113.TreeNode l4 = new PathSumII113.TreeNode(7);
        PathSumII113.TreeNode l5 = new PathSumII113.TreeNode(2);
        PathSumII113.TreeNode l6 = new PathSumII113.TreeNode(8);
        PathSumII113.TreeNode l7 = new PathSumII113.TreeNode(13);
        PathSumII113.TreeNode l8 = new PathSumII113.TreeNode(4);
        PathSumII113.TreeNode l9 = new PathSumII113.TreeNode(5);
        PathSumII113.TreeNode l10 = new PathSumII113.TreeNode(1);

        l1.left = l2;
        l2.left = l3;
        l3.left = l4;
        l3.right = l5;

        l1.right = l6;
        l6.left = l7;
        l6.right = l8;
        l8.left = l9;
        l8.right = l10;

        PathSumII113.TreeNode l11 = new PathSumII113.TreeNode(-2);
        PathSumII113.TreeNode l12 = new PathSumII113.TreeNode(-3);
        l11.left = l12;


        PathSumII113 l = new PathSumII113();
        l.pathSum(l11, -5);
 */
public class PathSumII113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Integer> currentPath = new Stack<>();
        checkPath(root, currentPath, result, 0, targetSum);

        return result;
    }

    public void checkPath(TreeNode root, Stack<Integer> currentPath, List<List<Integer>> result, int currentSum, int targetSum) {
        currentSum = currentSum + root.val;
        currentPath.add(root.val);
        if (currentSum == targetSum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(currentPath));
        } else {
            if (root.left != null) {
                checkPath(root.left, currentPath, result, currentSum, targetSum);
                currentPath.pop();
            }

            if (root.right != null) {
                checkPath(root.right, currentPath, result, currentSum, targetSum);
                currentPath.pop();
            }
        }
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
