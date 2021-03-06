package Array.Pep__Foundation;
import java.util.*;

//Good Question (important)
//Subset of an array
public class SubsetOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }

        int limit = (int) Math.pow(2,arr.length);
        for(int i=0;i<limit;i++){
            String set ="";
            int temp =i;

            for(int j=arr.length-1;j>=0;j--){
                //converting index to binary
                int r = temp % 2;
                temp = temp/2;

                if(r==0){
                    set = "-\t"+set;
                }else{
                    set = arr[j]+"\t"+set;
                }
            }
            System.out.println(set);
        }


    }
}
