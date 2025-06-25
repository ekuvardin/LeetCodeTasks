package solutions;

import java.util.HashMap;
import java.util.Map;

/*
yandex

 */
public class SubarraySumEqualsK560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;

        map.put(0,1);

        for(int num : nums) {
            sum = sum + num;


            if(map.get(sum - k) != null) {
                count = count + map.get(sum - k);
            }

            int prev = map.get(sum) == null ? 0 :  map.get(sum);

            map.put(sum, prev + 1);
        }

        return count;
    }
}
