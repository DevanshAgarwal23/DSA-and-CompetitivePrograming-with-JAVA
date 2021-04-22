package Array.Pep__Foundation;

import java.io.*;

//Span of Array
public class SpanOfArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int min = arr[0];
        int max = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }

            if(arr[i] > max){
                max = arr[i];
            }
        }

        int span = max - min;
        System.out.println(span);



//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i=0;i<n;i++){
//           arr[i]=sc.nextInt();
//        }
//
//        Arrays.sort(arr);
//        System.out.println(arr[n]-arr[n-1]);
    }
}
