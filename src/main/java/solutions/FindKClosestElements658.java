package solutions;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

    |a - x| < |b - x|, or
    |a - x| == |b - x| and a < b



Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3

Output: [1,2,3,4]

Example 2:

Input: arr = [1,1,2,3,4,5], k = 4, x = -1

Output: [1,1,2,3]



Constraints:

    1 <= k <= arr.length
    1 <= arr.length <= 104
    arr is sorted in ascending order.
    -104 <= arr[i], x <= 104


 */
public class FindKClosestElements658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr.length == 1) {
            return List.of(arr[0]);
        }

        int[] r = findPointer(arr,x);
        int left = r[0];
        int right = r[1];

        List<Integer> res = new ArrayList<>(k);

        for (int i = 0; i < k; i++) {
            int leftDiff = Integer.MAX_VALUE;
            int rightDiff = Integer.MAX_VALUE;

            if (left >= 0) {
                leftDiff = Math.abs(arr[left] - x);
            }

            if (right < arr.length) {
                rightDiff = Math.abs(arr[right] - x);
            }

            if (leftDiff <= rightDiff) {
                res.add(arr[left]);
                left--;
            } else {
                res.add(arr[right]);
                right++;
            }
        }

        res.sort(Integer::compare);
        return res;
    }

    public int[] findPointer(int[] arr, int x) {

        int left = 0;
        int right = arr.length - 1;
        int[] res = new int[2];

        while (left + 1 < right) {
            if (arr[left] == x) {
                res[0] = left;
                res[1] = left + 1;
                return res;
            }

            if (arr[right] == x) {
                res[0] = right;
                res[1] = right + 1;
                return res;
            }

            int mid = (left + right) / 2;
            if (arr[mid] <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (arr[left] == x) {
            res[0] = left - 1;
            res[1] = left + 1;
        } else if (arr[right] == x) {
            res[0] = right - 1;
            res[1] = right + 1;
        }
        return res;
    }

}
