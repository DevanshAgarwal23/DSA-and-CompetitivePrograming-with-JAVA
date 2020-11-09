package Sorting;

import java.util.Arrays;

public class BubbleSort {
    static void bubbleSort(int[] arr){
        for(int i=1;i<= arr.length-1;i++){
            for(int j=0;j< arr.length-i;j++){
                if(arr[j+1]<arr[j]){
                    swap(arr,j+1,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12,3453,442,74,6,33};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
