package solutions;

import java.util.Arrays;
import java.util.Objects;

/*
yandex
  SerializeandDeserializeBST449 l = new SerializeandDeserializeBST449();
        l.deserialize("2,1,0,-1,-1,-1,3,5,-1,-1,7,-1,9,-1,-1");
                      //      "2,1,0,-1,-1,-1,3,5,-1,-1,7,-1,9,-1,-1"
        SerializeandDeserializeBST449.TreeNode l1 = new SerializeandDeserializeBST449.TreeNode(2);
        SerializeandDeserializeBST449.TreeNode l2 = new SerializeandDeserializeBST449.TreeNode(1);
        SerializeandDeserializeBST449.TreeNode l3 = new SerializeandDeserializeBST449.TreeNode(0);
        SerializeandDeserializeBST449.TreeNode l4 = new SerializeandDeserializeBST449.TreeNode(3);
        SerializeandDeserializeBST449.TreeNode l5 = new SerializeandDeserializeBST449.TreeNode(5);
        SerializeandDeserializeBST449.TreeNode l6 = new SerializeandDeserializeBST449.TreeNode(7);
        SerializeandDeserializeBST449.TreeNode l7 = new SerializeandDeserializeBST449.TreeNode(9);

        l1.left = l2;
        l2.left = l3;

        l1.right = l4;
        l4.left = l5;
        l4.right = l6;
        l6.right = l7;

        l.serialize(l1);
 */
public class SerializeandDeserializeBST449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder res = new StringBuilder();
        serializeNode(root, res);
        res.deleteCharAt(res.length() - 1);

        return res.toString();
    }

    public void serializeNode(TreeNode node, StringBuilder res) {
        res.append(node.val);
        res.append(',');
        if (node.left == null) {
            res.append(-1);
            res.append(',');
        } else {
            serializeNode(node.left, res);
        }

        if (node.right == null) {
            res.append(-1);
            res.append(',');
        } else {
            serializeNode(node.right, res);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }


        int[] tokens = Arrays.stream(data.split(",")).mapToInt(Integer::parseInt).toArray();

        TreeNode currentNode = new TreeNode(tokens[0]);

        fillToken(currentNode, 1, tokens);

        return currentNode;
    }

    // 2 1 -1 null null null 3 5 null null 7 null 9 null null
    public int fillToken(TreeNode parentNode, int index, int[] tokens) {
        int idx = index;
        if (tokens[idx] != -1) {
            TreeNode currentNode = new TreeNode(tokens[idx]);
            parentNode.left = currentNode;
            idx = fillToken(currentNode, idx + 1, tokens);
        } else {
            idx++;
        }

        if (tokens[idx] != -1) {
            TreeNode currentNode = new TreeNode(tokens[idx]);
            parentNode.right = currentNode;
            idx = fillToken(currentNode, idx + 1, tokens);
        } else {
            idx++;
        }

        return idx;
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
