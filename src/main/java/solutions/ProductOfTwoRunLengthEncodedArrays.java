package solutions;

import java.util.ArrayList;
import java.util.List;

/*
Input: encoded1 = [[1,3],[2,1],[3,2]], encoded2 = [[2,3],[3,3]]

Output: [[2,3],[6,1],[9,2]]

Input: encoded1 = [[1,3],[2,3]], encoded2 = [[6,3],[3,3]]

Output: [[6,6]]

 */
public class ProductOfTwoRunLengthEncodedArrays {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result = new ArrayList<>();

        int pointerNum1 = 0;
        int pointerNum1Internal = 0;
        int pointerNum2 = 0;
        int pointerNum2Internal = 0;
        while (pointerNum1 < encoded1.length) {
            int num1Length = pointerNum1Internal == 0 ? encoded1[pointerNum1][1] : pointerNum1Internal;

            int num2Length = pointerNum2Internal == 0 ? encoded2[pointerNum2][1] : pointerNum2Internal;

            if (num1Length < num2Length) {
                addValues(result, encoded1[pointerNum1][0] * encoded2[pointerNum2][0], num1Length);
                pointerNum1++;
                pointerNum1Internal = 0;
                pointerNum2Internal = num2Length - num1Length;
            } else if (num1Length > num2Length) {
                addValues(result, encoded1[pointerNum1][0] * encoded2[pointerNum2][0], num2Length);
                pointerNum2++;
                pointerNum1Internal = num1Length - num2Length;
                pointerNum2Internal = 0;
            } else {
                addValues(result, encoded1[pointerNum1][0] * encoded2[pointerNum2][0], num1Length);
                pointerNum1++;
                pointerNum2++;
                pointerNum1Internal = 0;
                pointerNum2Internal = 0;
            }
        }

        return result;
    }

    private void addValues(List<List<Integer>> result, int value, int count) {
        List<Integer> list;
        if (!result.isEmpty() && (list = result.get(result.size() - 1)).get(0).equals(value)) {
            list.set(1, list.get(1) + count);
        } else {
            result.add(generateNewList(value, count));
        }
    }

    private List<Integer> generateNewList(int value, int count) {
        List<Integer> list = new ArrayList<>(2);
        list.add(value);
        list.add(count);
        return list;
    }
}
