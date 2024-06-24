package MultiThreading.PrintOddEven;

public class Main {
    public static void main(String... args) {
        Printer print = new Printer();
        Thread t1 = new Thread(new TaskEvenOdd(print, 10, false),"Odd");
        Thread t2 = new Thread(new TaskEvenOdd(print, 10, true),"Even");
        t1.start();
        t2.start();
    }
}
