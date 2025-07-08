package solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;


/*
yandex

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).



Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []



Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -100 <= Node.val <= 100

  BinaryreeZigzagLevelOrderTraversal103 l = new BinaryreeZigzagLevelOrderTraversal103();

        BinaryreeZigzagLevelOrderTraversal103.TreeNode l1 = new BinaryreeZigzagLevelOrderTraversal103.TreeNode(1);
        BinaryreeZigzagLevelOrderTraversal103.TreeNode l2 = new BinaryreeZigzagLevelOrderTraversal103.TreeNode(3);
        BinaryreeZigzagLevelOrderTraversal103.TreeNode l3 = new BinaryreeZigzagLevelOrderTraversal103.TreeNode(2);
        BinaryreeZigzagLevelOrderTraversal103.TreeNode l4 = new BinaryreeZigzagLevelOrderTraversal103.TreeNode(4);
        BinaryreeZigzagLevelOrderTraversal103.TreeNode l5 = new BinaryreeZigzagLevelOrderTraversal103.TreeNode(5);
        BinaryreeZigzagLevelOrderTraversal103.TreeNode l6 = new BinaryreeZigzagLevelOrderTraversal103.TreeNode(6);
        BinaryreeZigzagLevelOrderTraversal103.TreeNode l7 = new BinaryreeZigzagLevelOrderTraversal103.TreeNode(7);
        BinaryreeZigzagLevelOrderTraversal103.TreeNode l8 = new BinaryreeZigzagLevelOrderTraversal103.TreeNode(8);
        BinaryreeZigzagLevelOrderTraversal103.TreeNode l9 = new BinaryreeZigzagLevelOrderTraversal103.TreeNode(9);

        l1.left = l3;
        l1.right = l2;
        l3.left = l4;
        l3.right = l5;
        l2.left = l6;
        l2.right = l7;


        l.zigzagLevelOrder(l1);

 */
public class BinaryreeZigzagLevelOrderTraversal103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int size = queue.size();
        boolean isRightToTheLeft = false;

        while(!queue.isEmpty()) {
            ArrayDeque<TreeNode> tmp = new ArrayDeque<>();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode tt = queue.pollLast();
                temp.add(tt.val);
                if(isRightToTheLeft) {
                    addRight(tt, tmp);
                    addLeft(tt, tmp);
                } else {
                    addLeft(tt, tmp);
                    addRight(tt, tmp);
                }
            }

            res.add(temp);
            queue.addAll(tmp);
            size = queue.size();
            isRightToTheLeft = !isRightToTheLeft;
        }

        return res;
    }

    public void addLeft(TreeNode root, ArrayDeque<TreeNode> queue){
        if(root.left!=null) {
            queue.add(root.left);
        }
    }

    public void addRight(TreeNode root, ArrayDeque<TreeNode> queue){
        if(root.right!=null) {
            queue.add(root.right);
        }
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
