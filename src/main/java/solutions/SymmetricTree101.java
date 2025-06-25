package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
yandex
 */
public class SymmetricTree101 {
   /* public boolean isSymmetric(TreeNode root) {
        List<TreeNode> left = new ArrayList<>();
        left.add(root.left);
        List<TreeNode> right = new ArrayList<>();
        right.add(root.right);

        boolean res = true;
        while (!left.isEmpty() || !right.isEmpty()) {
            if (left.size() != right.size()) {
                return false;
            }


            for (int i = 0; i < left.size(); i++) {
                if(left.get(i) == null && right.get(i) == null || (left.get(i) != null && right.get(i) != null &&
                        left.get(i).val == right.get(i).val)) {
                    continue;
                } else {
                    return false;
                }
            }

            left = buildLeft(left);
            right = buildRight(right);
        }

        return res;
    }


    List<TreeNode> buildLeft(List<TreeNode> left) {
        List<TreeNode> newLeft = new ArrayList<>();

        for (TreeNode treeNode : left) {
            if (treeNode != null) {
                newLeft.add(treeNode.left);
                newLeft.add(treeNode.right);
            }
        }

        return newLeft;
    }

    List<TreeNode> buildRight(List<TreeNode> right) {
        List<TreeNode> newLeft = new ArrayList<>();

        for (TreeNode treeNode : right) {
            if (treeNode != null) {
                newLeft.add(treeNode.right);
                newLeft.add(treeNode.left);
            }
        }

        return newLeft;
    }*/

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right) {
        boolean result = checkNode(left, right);

        if (!result) {
            return false;
        }

        if (left != null) {
            return isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }

        return true;
    }

    boolean checkNode(TreeNode left, TreeNode right) {
        return left == null && right == null || left != null && right != null
                && left.val == right.val;
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
