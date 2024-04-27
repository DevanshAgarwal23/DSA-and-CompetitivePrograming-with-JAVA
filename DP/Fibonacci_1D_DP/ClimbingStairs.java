package DP.Fibonacci_1D_DP;

public class ClimbingStairs {

    //memoization - Top Down
    public int climbStairs(int n, int[] dp) {
        if(n<=1) return 1;

        if(dp[n] != -1) return dp[n];

        dp[n] = climbStairs(n-1, dp)+climbStairs(n-2, dp); // see the recurrence relation its very similar to that of fibonacci

        return dp[n];
    }

    public int climbingStairs(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }


}
