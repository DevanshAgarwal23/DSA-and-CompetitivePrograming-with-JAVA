package Mathematic.BigInteger;
/*
* //Big Integer Class in Java (Used to store integer which are bigger in size than long)
* //Powerful with lot of inbuilt  Function
* Modular Arithmetic
* GCD Calculation
*  Base Conversion
* Power Calculation
* Bitwise Operation
* Prime Generation and more
* */

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void playWithBigInteger() {

        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();

        BigInteger b1 = new BigInteger(s1);
        BigInteger b2 = new BigInteger("246127487248782");

        //b1 = b1.add(b2);
        b1 = b1.multiply(b2);
        System.out.println(b1);

        //Bit Count - total Set of Bits
        System.out.println(b1.bitCount());

        //Total No of Bits
        System.out.println(b1.bitLength());

        //Integer into Big Integer
        int a = sc.nextInt();
        int b = sc .nextInt();
        System.out.println(a+b);

        BigInteger b3 = BigInteger.valueOf(a);
        BigInteger b4 = BigInteger.valueOf(b);

        System.out.println(b3.gcd(b4));

        //Base Conversion
        //interpret the no in given base

        BigInteger b5 = new BigInteger("1001",2);
        System.out.println(b5);


        //power of number
        System.out.println(b3.pow(20));
    }


    public static void main(String[] args) {
        playWithBigInteger();
    }
}
