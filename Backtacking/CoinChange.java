package Backtacking;

public class CoinChange {

    static int count = 0;
    public static void main(String[] args) {

        permutation(new int[]{2, 3, 5, 6}, 10, "");

        // combination(new int[]{2, 3, 5, 6}, 10, "", 0);
    }

    public static void combination(int[] denom, int amount, String ans, int lastDenomUsed) {

        if (amount == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = lastDenomUsed; i < denom.length; i++) {

            if (amount >= denom[i]) {
                combination(denom, amount - denom[i], ans + denom[i], i);
            }
        }
    }

    public static void permutation(int[] denom, int amount, String ans) {

        if (amount == 0) {
            count++;
            System.out.println(count+"."+ans);
            return;
        }

        for (int i = 0; i < denom.length; i++) {
            if (amount >= denom[i]) {
                permutation(denom, amount - denom[i], ans + denom[i]);
            }
        }
    }


    public static  void combinationCoinResp(int[] denom,int amount,int vidx ,String ans){

        // +ve Base case
        if(amount ==0 ){
            System.out.println(ans);
            return;
        }

        // -ve BAse case
        if(amount < 0 || vidx == denom.length){
            return;
        }

        //yes contribute
        combinationCoinResp(denom,amount-denom[vidx],vidx,ans+denom[vidx]);

        //No contribution
        combinationCoinResp(denom,amount,vidx+1,ans);
    }
}