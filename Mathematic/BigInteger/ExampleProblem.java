package Mathematic.BigInteger;


import java.math.BigInteger;
import java.util.Scanner;

//Problem Name:- JULKA(SPOJ)
//link:- https://www.spoj.com/problems/JULKA/
public class ExampleProblem {

    static void compute(BigInteger n, BigInteger k){
        BigInteger x,y;
        x=n.subtract(k);
        x=x.divide(BigInteger.valueOf(2));
        y=x.add(k);
        System.out.println(y);
        System.out.println(x);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
}
