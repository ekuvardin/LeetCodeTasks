package solutions;

import java.util.*;

public class Intersetion {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> array = new HashSet<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; i++) {
            int current = nums1[i];

            while(j < nums2.length && current > nums2[j]) {
                j++;
            }

            if (j < nums2.length && current == nums2[j]) {
                array.add(nums1[i]);
                j++;
            }
            while (j < nums2.length && current == nums2[j]) {
                j++;
            }
        }
        return array.stream().mapToInt(i -> i).toArray();
    }
}