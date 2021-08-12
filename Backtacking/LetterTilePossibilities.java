package Backtacking;

public class LetterTilePossibilities {


    static int count;
    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAABBC"));
    }
    public static int numTilePossibilities(String tiles) {

        int[] freq = new int[26];

        for(int i=0;i<tiles.length();i++){
            char ch = tiles.charAt(i);
            freq[ch - 'A']++;
        }

        numTilePossibilities(freq,"");

        return count-1;
    }

    static void numTilePossibilities(int[] freq,String ans){

        System.out.println(ans);
        count++;

        for(int i = 0; i<freq.length;i++){
            if(freq[i] >0 ){
                freq[i]--;
                numTilePossibilities(freq,ans + (char)(i+'A'));
                freq[i]++;
            }
        }
    }
}
