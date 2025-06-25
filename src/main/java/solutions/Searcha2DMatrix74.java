package solutions;

/*
yandex
 */
public class Searcha2DMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int max = matrix[0].length *  matrix.length - 1;
        int maxY = matrix[0].length;

        while(low <= max - 2) {
            if(convert(low, matrix, maxY) == target || convert(max, matrix, maxY) == target) {
                return true;
            }

            int mid = (low + max) / 2;

            if(convert(mid, matrix, maxY)<target) {
                low = mid;
            } else {
                max = mid;
            }
        }

        return convert(low, matrix, maxY) == target || convert(max, matrix, maxY) == target;
    }

    int convert(int index, int[][] matrix, int maxY) {
        return matrix[(index - index % maxY)/maxY][index % maxY];
    }
}
