package Backtacking;

//Case 2:- coin can be used only one
//combination

public class CoinChange2 {

    public static void main(String[] args) {
        int[] denom = {1,2,3,4,5};
        userRespect(denom,0,7,"");
        coinRespect(denom,0,7,"");
    }

    public static void userRespect(int[] denom, int videx, int amount,String ans){

        //+ve base case
        if(amount ==0){
            System.out.println(ans);
            return;
        }

        //-ve base case
        if(amount < 0) return;

        for(int i=videx;i<denom.length;i++){
            userRespect(denom,i+1,amount-denom[i],ans+denom[i]);
        }
    }

    public static void coinRespect(int[] denom,int videx,int amount,String ans){

        //+ve base case
        if(amount == 0){
            System.out.println(ans);
            return;
        }

        //-ve base case
        if(amount < 0 || videx >= denom.length)
            return;

        // coin used
        coinRespect(denom,videx+1,amount-denom[videx],ans+denom[videx]);

        // coin not used
        coinRespect(denom,videx+1,amount,ans);
    }



    // coinChange ha 3 types:-
    /*
    * Case 1: infinite supply
    *
    * case 2 :- no duplicates and use one coin only
    *
    * case 3:- 
    * */
}
