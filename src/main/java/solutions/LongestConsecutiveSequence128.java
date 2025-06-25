package solutions;

import java.util.HashSet;

/*
  LongestConsecutiveSequence128 longestConsecutiveSequence128 = new LongestConsecutiveSequence128();
  longestConsecutiveSequence128.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1});

Yandex
 */
public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int result = 0;


        for(int num: nums) {
           if(set.contains(num)) {
               set.remove(num);
               int count = 1;

               int min = findBackward(num, set);
               count += min;

               int max = findForward(num, set);
               count += max;

               /*
               Addition fo task
               compress([1, 4, 5, 2, 3, 9, 8, 11, 0]) // '0-5,8-9,11'
                compress([1, 4, 3, 2]) // '1-4'
                compress([1, 4]) // '1,4'
                compress([1, 2]) // '1-2'
                */
/*
               if(min == max && min == 0){
                   System.out.println(num);
               } else {
                   System.out.println((num-min) + "-" + (num+max));
               }*/


               result = Math.max(result, count);
           }
        }

        return result;
    }

    private int findForward(int first, HashSet<Integer> set) {
        int result = 0;
        while (!set.isEmpty() && set.remove(first + result + 1) ) {
           result++;
        }

        return result;
    }

    private int findBackward(int first, HashSet<Integer> set) {
        int result = 0;
        while (!set.isEmpty() && set.remove(first - result - 1) ) {
            result++;
        }

        return result;
    }
}
