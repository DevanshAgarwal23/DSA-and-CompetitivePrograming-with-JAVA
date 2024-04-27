package DP.Fibonacci_1D_DP;

import java.util.ArrayList;

public class FrogJump {


    /*
    *  URL:- https://www.naukri.com/code360/problems/frog-jump_3621012
    * */

    public static int frogJump(int n, int heights[]) {

        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        return minEnergy(n-1, heights);
    }

    //Memoization
    public static int minEnergy(int n, int heights[], int[] dp) {

        if(n == 0) return 0;

        if(dp[n] != -1) return dp[n];

        int sp1 = minEnergy(n-1, heights, dp)+Math.abs(heights[n]-heights[n-1]);

        int sp2= Integer.MAX_VALUE;
        if(n>1){
            sp2 = minEnergy(n-2, heights, dp)+Math.abs(heights[n]- heights[n-2]);
        }

        dp[n] = Math.min(sp1, sp2);
        return dp[n];
    }

    public static int minEnergy(int n,int[] heights){
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i=1; i<=n; i++){
            int sp1 = dp[i-1]+Math.abs(heights[i]-heights[i-1]);

            int sp2= Integer.MAX_VALUE;
            if(i>1){
                sp2 = dp[i-2]+Math.abs(heights[i]- heights[i-2]);
            }

            dp[i] = Math.min(sp1, sp2);
        }

        return dp[n];
    }

}
