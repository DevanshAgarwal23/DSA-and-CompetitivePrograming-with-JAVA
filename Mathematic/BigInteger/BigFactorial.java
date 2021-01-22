package Mathematic.BigInteger;

import java.math.BigInteger;

public class BigFactorial {

   static BigInteger fact(int N){
       BigInteger b = new BigInteger("1");
       for (int i=2;i<=N;i++){
           b = b.multiply(BigInteger.valueOf(i));
       }
       return b;
   }

    public static void main(String[] args) {
        int N=100;
        System.out.println(fact(N));
    }
}
