package Searching;

public class Searching {


    //Time Complexity = O(N)
    public static int linearSearch(int[] a , int key){
        for(int i=0;i<a.length;i++){
            if(a[i]==key)
                return i;
        }
        return -1;
    }




    //Prerequisite for binary search ==> array should be sorted
    // Time Complexity = O(logN)
    public static int binarySearch(int[] a,int key){
        int l = 0;
        int h = a.length-1;
        while(l<=h){
            int mid = (l+h)/2;
            if(a[mid] == key){
                return mid;
            }else if(key>a[mid]){
                l=mid+1;
            }else{
                h=mid-1;
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr ={33,734,5346,87362,86765,2435,11,678};
        System.out.println(linearSearch(arr,11));
        int[] arr2 ={10,20,30,40,50,60,70,80,90};
        System.out.println(binarySearch(arr2,80));
    }
}
