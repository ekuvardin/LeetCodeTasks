package solutions;

import java.util.Stack;

/*
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.



Example 1:

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

Example 2:

Input: matrix = [["0"]]
Output: 0

Example 3:

Input: matrix = [["1"]]
Output: 1



Constraints:

    rows == matrix.length
    cols == matrix[i].length
    1 <= row, cols <= 200
    matrix[i][j] is '0' or '1'.

  MaximalRectangle85 n = new MaximalRectangle85();
        n.maximalRectangle( new char[][] { {'1'}});
        n.maximalRectangle( new char[][] { {'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
 */
public class MaximalRectangle85 {
    public int maximalRectangle(char[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int[] heights = new int[colCount];
        int maxArea = 0;

        for(int i = 0; i < rowCount; i++) {
            for(int j=0; j< colCount; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }

            Stack<Integer> stack = new Stack<>();

            for(int j = 0; j<colCount; j++) {
                if(stack.isEmpty() || heights[j] > heights[stack.peek()]) {
                    stack.push(j);
                } else {
                    while(!stack.isEmpty() && heights[j] <= heights[stack.peek()]) {
                        int height = heights[stack.pop()];
                        int width = stack.isEmpty() ? j : j - stack.peek() - 1;
                        maxArea = Math.max(maxArea, height * width);
                    }
                    stack.push(j);
                }
            }

            while(!stack.isEmpty()) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? colCount : colCount - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }
}
