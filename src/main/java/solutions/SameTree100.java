package solutions;

/*
yandex
 */
public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = checkNode(p, q);

        if (!result) {
            return false;
        }

        if (p != null) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return true;
    }

    boolean checkNode(TreeNode p, TreeNode q) {
        return p == null && q == null ||
                p != null && q != null && p.val == q.val;
    }

    public class TreeNode {
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
