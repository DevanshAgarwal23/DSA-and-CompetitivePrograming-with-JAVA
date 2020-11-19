package Sorting;

import java.util.Arrays;

public class QuickSort {

    //Quick Sort using Lomuto Partition Algorithm
    //Time-Complexity is O(N) and extra Space(Auxiliary-Space) is O(1)
    public static int lomutoPartition(int[] arr, int l, int h){
        int pivot = arr[h];
        int i=l-1;
        for(int j=l;j<=h-1;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,j,i);
            }
        }
        swap(arr,i+1,h);

        return (i+1);
    }
    public static void quickSortLomuto(int[] arr,int l,int h){
        if(l<h){
            int p = lomutoPartition(arr,l,h);
            quickSortLomuto(arr,l,p-1);
            quickSortLomuto(arr,p+1,h);
        }
    }

    //Quick sort using Hoare Partition
    //Time Complexity O(N) and Space Complexity O(1)
    public static int hoarePartition(int[] arr,int l, int h){
        //in hoare partition we take pivot as first element
        int pivot=arr[l];
        int i=l-1,j=h+1;
        while(true){
            do{
                i++;
            }while(arr[i]<pivot);

            do{
                j--;
            }while (arr[j]>pivot);

            if(i>=j)
                return j;

            swap(arr,i,j);
        }
    }
    public static void quickSortHoare(int[] arr,int l,int h){
        if(l<h){
            int p = hoarePartition(arr,l,h);
            quickSortHoare(arr,l,p);
            quickSortHoare(arr,p+1,h);
        }
    }

    public static void main(String[] args) {
        int[] arr = {33,65,22,12,545,76,25,4,9,5,12,33,87,7,99,33};
        quickSortHoare(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
