package solutions;

public class CountSubmatricesWitEqualFrequency3212 {

    public int numberOfSubmatrices(char[][] grid) {
        int cnt = 0;

        int len = grid.length;
        int width = grid[0].length;
        Pair[][] prefixSum = new Pair[len][width];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                if (i == j && i == 0) {
                    prefixSum[0][0] = new Pair(grid[0][0]);
                    continue;
                }

                if (i == 0) {
                    prefixSum[i][j] = new Pair(grid[i][j]);
                    prefixSum[i][j].plus(prefixSum[i][j - 1]);

                    if (prefixSum[i][j].countX > 0 && prefixSum[i][j].countX == prefixSum[i][j].countY) {
                        cnt++;
                    }
                } else if (j == 0) {
                    prefixSum[i][j] = new Pair(grid[i][j]);
                    prefixSum[i][j].plus(prefixSum[i - 1][j]);

                    if (prefixSum[i][j].countX > 0 && prefixSum[i][j].countX == prefixSum[i][j].countY) {
                        cnt++;
                    }
                } else {
                    prefixSum[i][j] = new Pair(grid[i][j]);
                    prefixSum[i][j].plus(prefixSum[i - 1][j]);
                    prefixSum[i][j].plus(prefixSum[i][j - 1]);
                    prefixSum[i][j].minus(prefixSum[i - 1][j - 1]);

                    if (prefixSum[i][j].countX > 0 && prefixSum[i][j].countX == prefixSum[i][j].countY) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    static class Pair {
        int countX;
        int countY;

        public Pair(char val) {
            if (val == 'X') {
                countX++;
            } else if (val == 'Y') {
                countY++;
            }
        }

        public void plus(Pair pair) {
            this.countX += pair.countX;
            this.countY += pair.countY;
        }

        public void minus(Pair pair) {
            this.countX -= pair.countX;
            this.countY -= pair.countY;
        }
    }
}
