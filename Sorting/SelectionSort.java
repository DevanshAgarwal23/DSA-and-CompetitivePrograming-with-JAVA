package Sorting;

import java.util.Arrays;

public class SelectionSort {
    static void selectionSort(int[] arr){
        for(int i=0;i< arr.length-1;i++){
            int min = i;
            for(int j = i+1;j< arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            swap(arr,i,min);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12,3453,442,74,6,33};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
