package solutions;

import java.util.ArrayList;
import java.util.List;

/*
The array-form of an integer num is an array representing its digits in left to right order.

    For example, for num = 1321, the array form is [1,3,2,1].

Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.



Example 1:

Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234

Example 2:

Input: num = [2,7,4], k = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455

Example 3:

Input: num = [2,1,5], k = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021



Constraints:

    1 <= num.length <= 104
    0 <= num[i] <= 9
    num does not contain any leading zeros except for the zero itself.
    1 <= k <= 104


 */
public class AddtoArrayFormofIntegerAvito {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>(num.length);
        List<Integer> adds = new ArrayList<>();

        int value = k;
        while (value > 9) {
            adds.add(0, value % 10);
            value = value / 10;
        }

        adds.add(0,value);

        int len1 = num.length - 1;
        int len2 = adds.size() - 1;
        int div = 0;

        while (len1 >= 0 || len2 >= 0 || div == 1) {
            int val = 0;
            if (len1 >= 0) {
                val = num[len1];
                len1--;
            }

            if (len2 >= 0) {
                val += adds.get(len2);
                len2--;

            }

            val += div;
            result.add(0, val % 10);
            div = val / 10;
        }

        return result;
    }
}
