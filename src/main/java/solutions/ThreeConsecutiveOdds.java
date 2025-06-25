package solutions;

public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length < 3) {
            return false;
        }

        boolean res = false;
        int i = 0;
        int countOdds = 0;

        while(i< arr.length && !res) {
            if(arr[i] % 2 == 0) {
                countOdds = 0;
            } else {
                countOdds++;
            }

            if(countOdds == 3) {
                res = true;
            }

            i++;
        }

        return res;
    }
}
