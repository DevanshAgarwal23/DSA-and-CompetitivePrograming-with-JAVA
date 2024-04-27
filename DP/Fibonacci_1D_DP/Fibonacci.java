package DP.Fibonacci_1D_DP;

public class Fibonacci {


    // Top- Down
    // TC : O(N)   SC:- O(N) + O(N)
    int memoization(int n, int[] dp){
        if(n<=1) return n;

        if(dp[n] != -1) return dp[n];

        dp[n] = memoization(n-1, dp) + memoization(n-2, dp);

        return dp[n];
    }

    // Bottom UP
    int tabulation(int n){

        int[] dp = new int[n+1];

        dp[0]=0;
        dp[1]=1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
