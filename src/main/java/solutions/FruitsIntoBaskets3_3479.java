package solutions;

public class FruitsIntoBaskets3_3479 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        int m = (int) Math.sqrt(n);
        int section = (int) Math.ceil((double) n / m);
        int count = 0;
        int[] maxV = new int[section];

        for (int i = 0; i < n; i++) {
            maxV[i / m] = Math.max(maxV[i / m], baskets[i]);
        }

        for (int fruit : fruits) {
            int sec;
            int unset = 1;

            for (sec = 0; sec < section && unset == 1; sec++) {
                if (maxV[sec] < fruit) {
                    continue;
                }
                int choose = 0;
                int maxInSection = 0;
                for (int pos = sec * m ; pos < Math.min((sec + 1) * m, n); pos++) {
                    if (baskets[pos] >= fruit && choose == 0) {
                        baskets[pos] = 0;
                        choose = 1;
                    }

                    maxInSection = Math.max(maxInSection, baskets[pos]);
                }
                maxV[sec] = maxInSection;
                unset = 0;
            }
            count += unset;
        }
        return count;
    }
}
