package solutions;

/*
yandex
 */
public class GuessNumberHigherorLower374 {
    public int guessNumber(int n) {
        int low = 1;
        int max = n;

        while(low <= max - 2) {
            if(guess(low) == 0) {
                return low;
            }

            if(guess(max) == 0) {
                return max;
            }

            int mid = (int) (((long) max + low) / 2);
            if(guess(mid) == 1) {
                low = mid;
            } else {
                max = mid;
            }
        }

        if(guess(low) == 0) {
            return low;
        } else {
            return max;
        }
    }

    int guess(int num){
        if(num == val) {
            return 0;
        } else if (num> val) {
            return -1;
        } else {
            return 1;
        }
    }

    int val = 0;

    public GuessNumberHigherorLower374(int num) {
        this.val = num;
    }


}
