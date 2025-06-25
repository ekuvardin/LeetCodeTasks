package solutions;

import java.util.ArrayDeque;
import java.util.Queue;

/*
yandex
 */
public class NumberofIslands200 {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        int[][] direction = new int[4][2];
        int xlen = grid.length;
        int ylen = grid[0].length;

        direction[0] = new int[]{0, 1};
        direction[1] = new int[]{0, -1};
        direction[2] = new int[]{1, 0};
        direction[3] = new int[]{-1, 0};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    grid[i][j] = '0';

                    Queue<Pair> queue = new ArrayDeque<>();
                    queue.add(new Pair(i, j));

                    while (!queue.isEmpty()) {
                        Pair pair = queue.poll();
                        for (int d = 0; d < 4; d++) {
                            int newX = pair.x + direction[d][0];
                            int newY = pair.y + direction[d][1];

                            if (newX >= 0 && newX < xlen && newY >= 0 && newY < ylen
                                    && grid[newX][newY] == '1') {
                                queue.add(new Pair(newX, newY));
                                grid[newX][newY] = '0';
                            }
                        }
                    }
                }
            }
        }

        return numberOfIslands;
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
