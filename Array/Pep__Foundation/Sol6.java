package Array.Pep__Foundation;
import java.io.*;
import java.util.*;

//Reverse an Array
public class Sol6 {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void reverse(int[] a){
        int n = a.length-1;
        // write your code here
        for (int i=0;i<a.length/2;i++){
            int temp = a[i];
            a[i] = a[n-i];
            a[n-i]=temp;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        reverse(a);
        display(a);
    }
}
