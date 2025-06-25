package solutions;

public class SqrtX69 {
    public int mySqrt(int x) {
        if (x < 1) {
            return 0;
        }

        int low = 1;
        int max = x / 2;

        while (low < max - 1) {
            if ((long) low * low == x) {
                return low;
            }

            if ((long) max * max == x) {
                return max;
            }

            int mid = (low + max) / 2;

            if ((long) mid * mid > x) {
                max = mid;
            } else {
                low = mid;
            }
        }

        if ((long)low * low == x) {
            return low;
        }

        if ((long)max * max == x) {
            return max;
        }

        if ((long)max * max < x) {
            return max;
        } else {
            return low;
        }
    }
}
