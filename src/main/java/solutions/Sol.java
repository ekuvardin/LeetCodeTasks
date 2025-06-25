package solutions;

import java.util.*;

class Sol {
    public int numSquares(int n) {
        int size = (int) Math.sqrt(n);
        Integer[] squares = new Integer[size];
        Set<Integer> diffs = new HashSet<>();
        for (int i = 1; i <= size; i++) {
            squares[i - 1] = i * i;
        }

        int step = 1;

        for (int i = 0; i < size; i++) {
            diffs.add(n - squares[i]);
        }

        Set<Integer> set = new HashSet<>();
        while (diffs.size() > 0 && !diffs.contains(0)) {
            for (int i = 0; i < size; i++) {
                for (Integer val : diffs) {
                    if (val - squares[i] > 0) {
                        set.add(val - squares[i]);

                    } else if (val - squares[i] == 0) {
                        return step + 1;
                    }
                }
            }
            diffs.clear();
            diffs.addAll(set);
            step++;
        }
        return step;
    }
}


