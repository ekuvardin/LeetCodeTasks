package solutions;

public class DefuseTheBomb {

    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] result = new int[len];

        if (k == 0) {
            return result;
        }

        for (int i = 0; i < len; i++) {
            int res = 0;
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    res += code[(i + j) % len];
                }
            } else {
                for (int j = 1; j <= Math.abs(k); j++) {
                    res += code[(len + (i - j)) % len];
                }
            }
            result[i] = res;
        }


        return result;
    }
}
