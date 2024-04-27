package DP.Knapsack_01;

import java.util.Arrays;

public class Knapsack_01 {


    public static void main(String[] args) {

    }

    public static int knapsackRecursive(int[] wt, int[] val, int n, int W){
        if(W==0 || n==0) return 0;

        if(wt[n-1] <= W){
            int sp1 = val[n-1]+knapsackRecursive(wt, val, n-1, W-wt[n-1]);
            int sp2 = knapsackRecursive(wt, val, n-1, W);
            return Math.max(sp1,sp2);
        }else{
            return knapsackRecursive(wt, val, n-1,W);
        }
    }


    // Memoization Approach
    public static int knapsackDP(int[] wt, int[] val, int n, int W, int[][] dp){
        if(W ==0 || n==0) return 0;

        if(dp[n][W] != -1)  return dp[n][W];


        if(wt[n-1] <= W){
            int sp1 = val[n-1]+knapsackRecursive(wt, val, n-1, W-wt[n-1]);
            int sp2 = knapsackRecursive(wt, val, n-1, W);
            dp[n][W] = Math.max(sp1,sp2);
        }else {
            dp[n][W] = knapsackRecursive(wt, val, n-1, W);
        }

        return dp[n][W];
    }


    //Bottom Up (Tabulation)
    public static int knapsack(int[] wt, int[] val, int n, int W){

        int[][] dp = new int[n+1][W+1];

        Arrays.fill(dp[0], 0);

        for(int i=0; i<W;i++){
            dp[0][i] = 0;
        }

        for(int i=1; i<n+1;i++){
            for(int j=1; j<W+1; j++){
                if(wt[n-1] <= W){
                    dp[i][j] = Math.max(val[i]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }

}
