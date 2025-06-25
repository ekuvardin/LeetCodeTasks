package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FindtheDifferenceofTwoArrays2215 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = new HashSet<>();
        Set<Integer> numSet2 = new HashSet<>();

        for (int temp : nums1) {
            numSet1.add(temp);
        }

        for (int temp : nums2) {
            numSet2.add(temp);
        }


        Set<Integer> numSet3 = new HashSet<>(numSet1);
        numSet3.retainAll(numSet2);

        numSet1.removeAll(numSet3);
        numSet2.removeAll(numSet3);

        List<List<Integer>> res = new ArrayList<>();

        res.add(0, new ArrayList<>(numSet1));
        res.add(1, new ArrayList<>(numSet2));

        return res;
    }
}
