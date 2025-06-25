package solutions;
/*
yandex
 */
public class CountPrimes204 {
    public int countPrimes(int n) {
        int[] set = new int[n];

        int res = 0;
        for(int i = 2; i<n; i++) {
            if(set[i] != 0) {
                continue;
            }
            res++;

            for(int j = i + i; j<n; j=j+i) {
                set[j] = 1;
            }

        }

        return res;
    }
}
