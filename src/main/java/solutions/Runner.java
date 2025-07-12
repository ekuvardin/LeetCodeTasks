package solutions;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws IOException, ParseException {
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
    }

}
