package solutions;

public class ReverseInteger7 {
    public int reverse(int x) {
        if (x == 0 || x == Integer.MIN_VALUE) {
            return 0;
        }

        String val = String.valueOf(x);

        int i = val.length() - 1;
        while (i > 0 && val.charAt(i) == '0') {
            i--;
        }

        val = val.substring(0, i + 1);
        StringBuilder builder = new StringBuilder(val).reverse();
        if (x < 0) {
            val = builder.substring(0, builder.length() - 1);
        } else {
            val = builder.toString();
        }

        long res = Long.parseLong(val);

        if (x < 0) {
            res = res * (-1);
        }

        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) res;
    }

    public boolean isPalindrome(int x) {
        StringBuilder builder = new StringBuilder();
        builder.append(x);
        String first = builder.toString();

        return first.contentEquals(builder.reverse());
    }
}
