package solutions;

import java.util.ArrayList;
import java.util.Arrays;
/*

        IntersectionOfTwoArrays349 intersectionOfTwoArrays349 = new IntersectionOfTwoArrays349();
        intersectionOfTwoArrays349.intersection(new int[] { 4,9,5}, new int[] { 9,4,9,8,4});

        Yandex
 */
public class IntersectionOfTwoArrays349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> res = new ArrayList<>();

        int pointer1 = 0;
        int pointer2 = 0;

        while (pointer1 < nums1.length && pointer2 < nums2.length) {
            if (nums1[pointer1] == nums2[pointer2]) {
                if (res.isEmpty() || res.get(res.size() - 1) != nums1[pointer1]) {
                    res.add(nums1[pointer1]);
                }
                pointer1++;
                pointer2++;
            } else if (nums1[pointer1] > nums2[pointer2]) {
                pointer2++;
            } else {
                pointer1++;
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
