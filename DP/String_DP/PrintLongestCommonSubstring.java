package DP.String_DP;

import java.util.Arrays;

public class PrintLongestCommonSubstring {
    public static void main(String args[])
    {
        String X = "OldSite:GeeksforGeeks.org";
        String Y = "NewSite:GeeksQuiz.com";

        int m = X.length();
        int n = Y.length();

        String ans = printLCSubStr(X, Y);
        System.out.println(ans);
    }

    private static String printLCSubStr(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for(int[] sub : dp) Arrays.fill(sub, 0);

        int maxLen =0;
        int maxR=0, maxC=0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];

                if(maxLen<dp[i][j]){
                    maxLen = dp[i][j];
                    maxR = i;
                    maxC = j;
                }
            }
        }

        String ans = "";
        while (dp[maxR][maxC] != 0){
            ans = s1.charAt(maxR-1) + ans;
            maxR--;
            maxC--;
        }

        return ans;
    }


}
