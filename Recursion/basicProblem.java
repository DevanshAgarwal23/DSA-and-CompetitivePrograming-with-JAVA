package Recursion;

public class basicProblem {

    public static void PD(int n) { // BP : n to 1 counting dec

        if (n == 0)
            return;

        System.out.println(n);
        PD(n - 1); // SP : n-1 to 1 dec

    }

    public static void PI(int n) {

        if (n == 0)
            return;

        PI(n - 1);
        System.out.println(n);

    }

    public static void PDI(int n) {

        if (n == 0) {
            return;
        }

        System.out.println("hi " + n);
        PDI(n - 1);
        System.out.println("bye " + n);
    }

    public static int factorial(int n) { // bp

        if (n == 1) {
            return 1;
        }

        int fnm1 = factorial(n - 1); // sp
        int fn = fnm1 * n; // sw

        return fn;

        // return factorial(n - 1) * n;

    }

    public static int power(int x, int n) {

        if (n == 0) {
            return 1;
        }

        int sp = power(x, n - 1);
        int bp = sp * x;

        return bp;

    }

    public static int fibonacci(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        int fnm1 = fibonacci(n - 1);
        int fnm2 = fibonacci(n - 2);

        int fn = fnm1 + fnm2;

        return fn;

    }




}
