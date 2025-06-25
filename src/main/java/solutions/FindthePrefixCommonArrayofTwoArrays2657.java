package solutions;

import java.util.HashSet;
import java.util.Set;

/*
yandex

 FindthePrefixCommonArrayofTwoArrays2657 l = new FindthePrefixCommonArrayofTwoArrays2657();
        l.findThePrefixCommonArray(new int[]{1,3,2,4}, new int[]{3,1,2,4});
 */
public class FindthePrefixCommonArrayofTwoArrays2657 {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> arr1 = new HashSet<>(A.length);
        Set<Integer> arr2 = new HashSet<>(B.length);

        int[] res = new int[A.length];
        int cur = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (arr1.contains(B[i])) {
                cur++;
            }

            if (arr2.contains(A[i])) {
                cur++;
            }

            if (A[i] == B[i]) {
                cur++;
            }

            res[i] = cur;
            arr1.add(A[i]);
            arr2.add(B[i]);
        }

        res[A.length - 1] = A.length;

        return res;
    }
}
