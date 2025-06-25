package solutions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 new int[][] {{1,1},{3,1}}
 true
 */
public class LineReflectionYandex {
    public boolean isReflected(int[][] points) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<List<Integer>> set = new HashSet<>();
        for(int[] point : points) {
            min = Math.min(min,point[0]);
            max = Math.max(max,point[0]);
            set.add(List.of(point[0], point[1]));
        }

        int distance = max+min;

        for(int[] point : points) {
            if(!set.contains(List.of(distance - point[0], point[1]))){
                return false;
            }
        }

        return true;
    }

}
