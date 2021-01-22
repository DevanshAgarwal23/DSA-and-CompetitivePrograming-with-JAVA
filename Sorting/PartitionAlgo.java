package Sorting;


import java.util.Arrays;

//partition algorithm for pivot of choice
public class PartitionAlgo {

    //Time is O(N) and O(N) extra space
    public static void naivePartition(int[] arr , int l, int h, int p) {
        int[] temp = new int[h-l+1];
        int index=0;
        for(int i=l;i<=h;i++){
            if(arr[i]<=p){
                temp[index]=arr[i];
                index++;
            }
        }

        for(int i=l;i<=h;i++){
            if(arr[i]>p){
                temp[index]=arr[i];
                index++;
            }
        }
        for(int i=l;i<=h;i++)
            arr[i]=temp[i-l];
    }

    //Time-complexity O(n) and extra space required is O(1)
    public static void lomutoPartition(int[] arr, int l , int h, int pivot){
        int i=l-1;
        for(int j=l;j<=h;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {33,6,88,344,56,78,33,22,12,3,5,74,3,6,7};

        lomutoPartition(arr,0,arr.length-1,80);
        System.out.println(Arrays.toString(arr));
    }


    static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
