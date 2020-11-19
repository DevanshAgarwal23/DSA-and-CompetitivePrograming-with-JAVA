package Sorting;

import java.util.Arrays;

public class MergeSort {

    public  void merge(int[] arr , int l , int m , int h){
        int n1 = m-l+1;
        int n2 = h-m;
        int[] a = new int[n1];
        int[] b = new int[n2];

        //copy data to temp arrays
        for(int i=0;i<n1;i++){
            a[i] = arr[l+i];
        }
        for(int j=0;j<n2;j++){
            b[j] = arr[m+1+j];
        }

        int i=0,j=0;
        int k =l;
        
        while(i<n1 && j< n2){
            if(a[i]<=b[j]){
                arr[k] = a[i];
                i++;
                k++;
            }else{
                arr[k] = b[j];
                j++;
                k++;
            }
        }

        while(i<n1){
            arr[k]=a[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k] = b[j];
            j++;
            k++;
        }
    }

    public   void mergeSort(int[] arr,int l,int h){
        if( l < h){
            int m = (l+h)/2; //same as (l+h)/2

            mergeSort(arr,l,m);
            mergeSort(arr,m+1,h);
            merge(arr,l,m,h);
        }

    }

    public static void main(String[] args) {
        int[] arr = {23,76,344,67,978};
        MergeSort mr = new MergeSort();
        mr.mergeSort(arr,0,  arr.length-1);
        System.out.println(Arrays.toString(arr));
    }



}
