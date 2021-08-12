package Backtacking;
import java.util.*;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    static int max;
    public static void main(String[] args) {

        max =0;
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        userRespect(arr,0,"");
    }


    public static void userRespect(List<String> arr,int vidx,String ans){

        if(distinctChar(ans)){
            //System.out.println(ans);
            if(ans.length() > max) max=ans.length();
        }

        else
            return;

        for(int i=vidx;i<arr.size();i++){
            userRespect(arr,i+1,ans+arr.get(i));
        }
    }

    static boolean distinctChar(String str){
        int[] freq = new int[26];

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(freq[ch-'a'] > 0) return false;

            freq[ch-'a']++;
        }

        return true;
    }
}
