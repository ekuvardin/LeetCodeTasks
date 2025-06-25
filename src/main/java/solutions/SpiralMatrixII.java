package solutions;

/*
yandex
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int cnt = 1;

        int pointX = 0;
        int pointY = 0;
        Direction direction = Direction.right;

        while (cnt <= n * n) {

            if (direction == Direction.right) {
                while (pointY < n && res[pointX][pointY] == 0) {
                    res[pointX][pointY] = cnt;
                    pointY++;
                    cnt++;
                }
                pointY--;
                pointX++;
                direction = Direction.bottom;
            }

            if (cnt <= n * n && direction == Direction.bottom) {
                while (pointX < n && res[pointX][pointY] == 0) {
                    res[pointX][pointY] = cnt;
                    pointX++;
                    cnt++;
                }
                pointX--;
                pointY--;
                direction = Direction.left;
            }

            if (cnt <= n * n && direction == Direction.left) {
                while (pointY >= 0 && res[pointX][pointY] == 0) {
                    res[pointX][pointY] = cnt;
                    pointY--;
                    cnt++;
                }
                pointY++;
                pointX--;
                direction = Direction.top;
            }

            if (cnt <= n * n && direction == Direction.top) {
                while (pointX >=0 && res[pointX][pointY] == 0) {
                    res[pointX][pointY] = cnt;
                    pointX--;
                    cnt++;
                }
                pointX++;
                pointY++;
                direction = Direction.right;
            }
        }


        return res;
    }

    public enum Direction {
        left, right, top, bottom;
    }

}
