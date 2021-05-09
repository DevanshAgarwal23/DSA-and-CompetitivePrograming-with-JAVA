package Array.Pep__Foundation;
import java.util.*;

//First index and Last Index
public class FirstLastIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int d = sc.nextInt();

        int l = 0;
        int h = arr.length;

        while(l<=h){
            int mid = (l+h)/2;
            if(d>arr[mid]){
                l=mid+1;
            }else if(d<arr[mid]){
                h= mid-1;
            }else{
                int first = mid;
                int last = mid;
                while(arr[first]==arr[mid]){
                    first--;
                }
                while(arr[last]==arr[mid]){
                    last++;
                }
                System.out.println(first+1);
                System.out.println(last-1);
                break;
            }
        }
        if (l > h) {
            System.out.println(-1);
            System.out.println(-1);
        }
    }
}
