package Array.Pep__Fond;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,arr[i]);
        }
        for(int floor=max;floor>=1;floor--){
            for(int val: arr){
                if(val>=floor){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
