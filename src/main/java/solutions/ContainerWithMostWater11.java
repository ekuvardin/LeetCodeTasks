package solutions;

/*
yandex
 */
public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int low = 0;
        int max = height.length - 1;
        int res = 0;

        while(low < max) {
            int mins = Math.min(height[low], height[max]);
            res=Math.max(res, mins * (max - low));

            while(low < max && height[low] <= mins) {
                low++;
            }

            while(low < max && height[max] <= mins) {
                max--;
            }
        }

        return res;
    }
}
