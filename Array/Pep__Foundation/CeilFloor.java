package Array.Pep__Foundation;
import java.util.*;

//Ceil and Floor
public class CeilFloor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        int d = sc.nextInt();
        // proper algo implementation
        ceilFloor(arr,d);

       // Using Arrays Class in java
      /*
        int res = Arrays.binarySearch(arr,d);
        if(res>=0){
            System.out.println(arr[res]);
            System.out.println(arr[res]);

        }else{
            res=Math.abs(res);
            System.out.println(res);
            System.out.println(arr[res-1]);
            System.out.println(arr[res-2]);
        }

     */
    }

    public static void ceilFloor(int[] a , int key){
        int l = 0;
        int h = a.length;
        int ceil = Integer.MAX_VALUE;
        int floor = Integer.MIN_VALUE;
        while(l <= h){
            int mid = (l+h)/2;
            if(key>a[mid]){
                l=mid+1;
                floor=a[mid];
            }else if(key<a[mid]){
                h=mid-1;
                ceil=a[mid];
            }else{
                floor=a[mid];
                ceil=a[mid];
                break;
            }
        }
        System.out.println(ceil);
        System.out.println(floor);
    }
}
