package Array.Pep__Foundation;
import java.io.*;
import java.util.*;

//Rotate an Array
public class RotateArrray {
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    // O(N) time complexity
    public static void reverse(int[] a,int li,int ri){
        while(li < ri){
            int temp = a[li];
            a[li]=a[ri];
            a[ri] = a[li];

            li++;
            ri--;
        }
    }
    public static void rotate(int[] a , int k){
        k = k % a.length;
        if(k<0)
            k = k + a.length;

        reverse(a,0,a.length-k-1);
        reverse(a,a.length-k,a.length-1);
        reverse(a,0,a.length-1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        rotate(a, k);
        display(a);
    }

    //Naive Solution O(n^2) time complexity
  /*
    public static void rotate(int[] a, int k){
        int n = a.length-1;
        k=k%(a.length);
        if(k<0){
            k=k+a.length;
        }
        for(int i=0;i<k;i++){
            int temp = a[n];
            for(int j=n;j>0;j--){
                a[j]=a[j-1];
            }
            a[0]=temp;
        }

    }
  */
}
