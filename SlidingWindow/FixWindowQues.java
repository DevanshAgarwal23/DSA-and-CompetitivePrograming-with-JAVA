package SlidingWindow;

import java.util.*;

public class FixWindowQues {


    /* 1. Leetcode:- 1876. Substrings of Size Three with Distinct Characters
    A string is good if there are no repeated characters.
    Given a string s, return the number of good substrings of length three in s.

    Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
    A substring is a contiguous sequence of characters in a string.
    Example 1:

    Input: s = "xyzzaz"
    Output: 1
    Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
    The only good substring of length 3 is "xyz".
    Example 2:

    Input: s = "aababcabc"
    Output: 4
    Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
    The good substrings are "abc", "bca", "cab", and "abc".
    * */
    public int countGoodSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int count = 0;
        while (j < s.length()) {
            if (j - i + 1 < 3) {
                map.put(s.charAt(j),
                        map.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            } else {
                map.put(s.charAt(j),
                        map.getOrDefault(s.charAt(j), 0) + 1);

                if (map.size() == 3) count++;

                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);

                if (map.get(s.charAt(i)) <= 0) map.remove(s.charAt(i));
                i++;
                j++;
            }
        }

        return count;
    }

    /*2. GFG:- Count of substrings of length K with exactly K distinct characters

    Given string str of the lowercase alphabet and an integer K,
    the task is to count all substrings of length K which have exactly K distinct characters.

    Ex1:
        Input: str = “abcc”, K = 2
        Output: 2
        Explanation:
        Possible substrings of length K = 2 are
        ab : 2 distinct characters
        bc : 2 distinct characters
        cc : 1 distinct character
        Only two valid substrings exist {“ab”, “bc”}.
    Ex2:
        Input: str = “aabab”, K = 3
        Output: 0
        Explanation:
        Possible substrings of length K = 3 are
        aab : 2 distinct characters
        aba : 2 distinct characters
        bab : 2 distinct characters
        No substrings of length 3 exist with exactly 3 distinct characters.
    */
    public int countSubStringSizeK(String s,int k){
        // same solution as 1st ques, just replace 3 with k
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int count = 0;
        while (j < s.length()) {
            if (j - i + 1 < k) {
                map.put(s.charAt(j),
                        map.getOrDefault(s.charAt(j), 0) + 1);
                j++;
            } else {
                map.put(s.charAt(j),
                        map.getOrDefault(s.charAt(j), 0) + 1);

                if (map.size() == k) count++;

                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);

                if (map.get(s.charAt(i)) <= 0) map.remove(s.charAt(i));
                i++;
                j++;
            }
        }

        return count;
    }


    /*  Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
        Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

        Example 1:
            Input: s = "abciiidef", k = 3
            Output: 3
            Explanation: The substring "iii" contains 3 vowel letters.
        Example 2:
            Input: s = "aeiou", k = 2
            Output: 2
            Explanation: Any substring of length 2 contains 2 vowels.
        Example 3:
            Input: s = "leetcode", k = 3
            Output: 2
            Explanation: "lee", "eet" and "ode" contain 2 vowels.
    */
    public int maxVowels(String s, int k) {

        int ans = 0;
        int vowelCount = 0;
        int i=0,j=0;
        while(j<s.length()){

            if(j-i+1<k){
                if(isVowel(s.charAt(j))) vowelCount++;
                j++;
            }else{
                if(isVowel(s.charAt(j))) vowelCount++;
                ans = Math.max(ans,vowelCount);

                //remove the i'th element and reduce vowelCount if its a vowel

                if(isVowel(s.charAt(i))) vowelCount--;
                i++;
                j++;

            }
        }

        return ans;
    }

    boolean isVowel(char c){
        HashSet<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        return vowel.contains(c);
    }


}
