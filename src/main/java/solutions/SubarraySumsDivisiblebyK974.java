package solutions;

import java.util.HashMap;
import java.util.Map;
/*
yandex
 */
public class SubarraySumsDivisiblebyK974 {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for(int i=0; i<nums.length;i++) {
            sum = sum + nums[i];

            if(sum % k == 0) {
                count++;
            }

            int mod = sum % k;
            if(mod < 0) {
                mod = mod +k;
            }

            if(map.get(mod) == null) {
                map.put(mod, 1);
            } else {
                count = count + map.get(mod);
                map.put(mod, map.get(mod) + 1);
            }
        }

        return count;
    }
}
