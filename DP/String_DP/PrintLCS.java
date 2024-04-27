package DP.String_DP;
import java.util.*;

public class PrintLCS {
    public static void main(String[] args) {
        String a = "abcde";
        String b = "bdgek";
        System.out.println(LCS(a, b));
    }


    private static String reverse(String str) {
        String ans = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            ans += str.charAt(i);
        }
        return ans;
    }

    private static String max_str(String a, String b) {
        return a.length() > b.length() ? a : b;
    }

    static String LCS_core(int idx1, int idx2, String s1, String s2, HashMap<Integer, HashMap<Integer, String>> dp){

        if(idx1 < 0 || idx2 < 0) return "";

        // if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(dp.containsKey(idx1) && dp.get(idx1).containsKey(idx2)) return dp.get(idx1).get(idx2);

        String ans = "";

        if(s1.charAt(idx1) == s2.charAt(idx2)) {
            ans +=  s1.charAt(idx1) + LCS_core(idx1-1,idx2-1, s1, s2, dp);
        }
        else ans+= max_str(LCS_core(idx1-1,idx2,s1,s2, dp), LCS_core(idx1,idx2-1,s1,s2, dp));

        if(!dp.containsKey(idx1)) dp.put(idx1, new HashMap<>());

        dp.get(idx1).put(idx2, ans);

        return ans;
    }


    private static String LCS(String a, String b) {
        HashMap<Integer, HashMap<Integer, String>> dp = new HashMap<>();

        String ans =  reverse(LCS_core(a.length()-1,b.length()-1,a, b, dp));
        System.out.println(dp.toString());
        return ans;
    }

}
