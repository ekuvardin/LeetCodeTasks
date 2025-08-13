package solutions;

public class ProductQueries {

    public  int[] productQueries(int n, int[][] queries) {
        int[] power = new int[32];
        int length = 0;
        int value = 1;
        final int mod = 1000000007;


        do {
            if ((n & 1) == 1) {
                power[length] = value;
                length++;
            }

            value *= 2;
            n = n >> 1;
        } while (n > 0);

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long temp = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                temp = (temp * power[j]) % mod;
            }
            res[i] = (int) temp;
        }

        return res;
    }

}
