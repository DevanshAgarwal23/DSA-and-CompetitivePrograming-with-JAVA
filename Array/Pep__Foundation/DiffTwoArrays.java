package Array.Pep__Foundation;
import java.util.*;

//Difference of two Arrays
public class DiffTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0;i< arr1.length;i++){
            arr1[i]=sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0;i< arr2.length;i++){
            arr2[i]=sc.nextInt();
        }

        sol(arr1,arr2);
    }

    public static void sol(int[] a1 , int[] a2){
        int[] diff = new int[a2.length];
        int n = a1.length-1;
        int m = a2.length-1;
        int k = diff.length-1;
        int c =0;
        while(k>=0){
            int d=0;
            int a1Val = n >=0 ? a1[n] : 0;
            if(a2[m]+c >= a1Val){
                d = a2[m]+c-a1Val;
                c=0;
            }else{
                d = a2[m]+c+10-a1Val;
                c=-1;
            }
            diff[k]=d;
            n--;
            m--;
            k--;
        }
        int i=0;
        while(i < diff.length){
            if(diff[i]==0){
                i++;
            }else{
                break;
            }
        }
        while(i< diff.length){
            System.out.println(diff[i]);
            i++;
        }
    }
}
