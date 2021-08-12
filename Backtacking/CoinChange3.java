package Backtacking;

// Case 3 { imp }

public class CoinChange3 {
    public static void main(String[] args) {
        int[] denom = { 1,2,2,3,4};
        userRespect(denom,0,7,"");
    }

    public static void userRespect(int[] denom , int videx,int amount,String ans){

        //+ve base case
        if(amount ==0){
            System.out.println(ans);
            return;
        }

        // -ve base case
        if(amount < 0) return;

        for(int i = videx;i<denom.length;i++){

            if( i > videx && denom[i] == denom[i-1])
                continue;


            userRespect(denom,i+1,amount-denom[i],ans+denom[i]);

        }
    }


    // call = true (include) & call= false (exclude)
    public static void coinRespect(int[] denom, int videx, int amount, String ans,boolean call){
        //+ve base case
        if(amount == 0){
            System.out.println(ans);
            return;
        }

        //-ve base case
        if(amount < 0 || videx >= denom.length)
            return;


        if(call ==  false && denom[videx] == denom[videx-1] ){

            //only exclude call
            coinRespect(denom,videx+1,amount,ans,false);
        }else{
            // include
            coinRespect(denom,videx+1,amount-denom[videx],ans+denom[videx],true);
            // exclude
            coinRespect(denom,videx+1,amount,ans,false);
        }
    }
}
  