package solutions;

public class ClimbStairs {

    public int climbStairs(int n) {
        if(n <= 3) {
            return n;
        }

        int[] fib = new int[n];
        fib[0] =1;
        fib[1] =2;
        fib[2]= 3;

        for(int i =3;i<n;i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[n - 1];

    }
}
