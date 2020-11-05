package Array.Pep__Fond;
import java.io.*;
import java.util.Arrays;

//Find Element in an Array
public class Sol2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int key = Integer.parseInt(br.readLine());
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);

    }
}
