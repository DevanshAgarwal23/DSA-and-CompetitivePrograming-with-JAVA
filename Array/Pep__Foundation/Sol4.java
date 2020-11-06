package Array.Pep__Foundation;
import java.util.*;

//Sum of two array
public class Sol4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0;i<arr1.length;i++){
            arr1[i]= sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0;i<arr2.length;i++){
            arr2[i]= sc.nextInt();
        }

        sol(arr1,arr2);

    }

    public static void sol(int[] a1, int[] a2){
        int n = a1.length;
        int m = a2.length;

        int[] sum = new int[Math.max(n, m)];
        int i = n-1;
        int j = m-1;
        int k = sum.length -1;
        int c =0;
        while(k>=0){
            int d =c;
            if(i>=0)
                d+=a1[i];
            if(j>=0)
                d+=a2[j];

            c = d/10;
            d = d%10;
            sum[k] = d;
            i--;
            j--;
            k--;

        }

        if(c>0)
            System.out.println(c);
        for(int var:sum)
            System.out.println(var);

    }
}
