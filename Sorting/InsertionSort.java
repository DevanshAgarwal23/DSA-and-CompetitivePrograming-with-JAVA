package Sorting;

import java.util.Arrays;

public class InsertionSort {
    static void iSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    public static void main(String[] args) {
        int[] array = {20,40,30,50,60};
        iSort(array);
        System.out.println(Arrays.toString(array));
    }
}
