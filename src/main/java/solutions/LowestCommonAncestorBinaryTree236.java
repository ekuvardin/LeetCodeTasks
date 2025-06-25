package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/*
yandex
 */
public class LowestCommonAncestorBinaryTree236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> val1 = findVal(root, p);
        List<TreeNode> val2 = findVal(root, q);

        int pointer = 0;
        TreeNode res = null;

        while (pointer <val1.size() && pointer < val2.size() && val1.get(pointer) == val2.get(pointer)) {
            res = val1.get(pointer);
            pointer++;
        }

        return res;
    }

    public List<TreeNode> findVal(TreeNode root, TreeNode cur) {
        List<TreeNode> res = new ArrayList<>();
        checkVal(res, root, cur);
        return res;
    }

    public boolean checkVal(List<TreeNode> res, TreeNode root, TreeNode cur) {
        res.add(root);
        if (root == cur) {
            return true;
        }

        if (root.left != null) {
            boolean r = checkVal(res, root.left, cur);
            if (r) {
                return true;
            } else {
                res.remove(res.size() - 1);
            }
        }

        if (root.right != null) {
            boolean r = checkVal(res, root.right, cur);
            if (r) {
                return true;
            } else {
                res.remove(res.size() - 1);
            }
        }

        return false;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left != null && right != null) return root;
        if (left != null) return left;
        return right;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


