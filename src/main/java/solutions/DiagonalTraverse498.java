package solutions;

public class DiagonalTraverse498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int direction = 1;

        int i = 0;
        int j = 0;
        int pointer = 0;

        int lengthX = mat.length;
        int lenghtY = mat[0].length;

        int[] res = new int[lengthX * lenghtY];

        while(i!=lengthX && j != lenghtY) {
            res[pointer] = mat[i][j];
            pointer++;
            if(direction == 1) {
                if(i == 0 || j == lenghtY - 1) {
                    direction = -1;
                    if(i == 0 && j != lenghtY - 1) {
                        j++;
                    } else {
                        i++;
                    }
                } else {
                    i--;
                    j++;
                }
            } else {
                if(j == 0 || i == lengthX - 1) {
                    direction = 1;
                    if(j == 0 && i != lengthX - 1) {
                        i++;
                    } else {
                        j++;
                    }
                } else {
                    i++;
                    j--;
                }
            }
        }

        return res;
    }
}
