package solutions;

public class WaystoExpressanIntegerasSumofPowers2787 {

    public static int numberOfWays(int n, int x) {
        int MOD = (int) (1e9 + 7);
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1;  Math.pow(i, x) <= n; i++) {
            long power = (long) Math.pow(i, x);

            for (int j = n; j >= power; j--) {
                dp[j] =  (dp[j] + dp[j - (int) power]) % MOD;
            }
        }

        return dp[n];
    }
}
