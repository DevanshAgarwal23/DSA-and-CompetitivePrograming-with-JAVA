package Sorting;

import java.util.Arrays;

public class InsertionSort {
    static void iSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]>arr[j+1])
                    swap(arr,j,j+1);
                else
                    break;
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {203,10,30,5,60};
        iSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
