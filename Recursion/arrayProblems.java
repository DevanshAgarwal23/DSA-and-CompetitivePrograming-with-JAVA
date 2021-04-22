package Recursion;

public class arrayProblems {


    /*
    * NOTE :-- When we make recursive call at the start
    *          of the function (when we are dealing with arrays)
    *          we first travers till the last element of the array
    *          and then return back to the main function.
    */


    public static void displayArray(int[] arr, int idx){
        if(idx == arr.length)
            return;

        System.out.println(arr[idx]);
        displayArray(arr,idx+1);
    }

    public  static void reverseDisplayArray(int[] arr, int idx){
        if(idx == arr.length)
            return;

        reverseDisplayArray(arr, idx+1);
        System.out.println(arr[idx]);
    }

    public static int max(int[] arr, int idx) {

        int maxTillNow,maxTotal;
        if(idx == arr.length-1)
            return arr[idx];

        maxTillNow = max(arr, idx+1);
        maxTotal = Math.max(maxTillNow, arr[idx]);

        return maxTotal;
    }

    public static int firstOccIndex(int[] arr, int idx,int item) {
        if(idx == arr.length)
            return -1;

        if(arr[idx]==item)
            return idx;

        return firstOccIndex(arr,idx+1,item);
    }

    //imp
    public static int lastOccIndex(int[] arr, int idx, int item) {
        if(idx == arr.length)
            return -1;

        int sp = firstOccIndex(arr,idx+1,item);

        if(arr[idx]==item && sp==-1 )
            return idx;

        return sp;
    }

    //imp
    public static int[] allIndex(int[] arr,int idx, int item, int count) {

        if(idx==arr.length){
            int[] br = new int[count];
            return br;
        }

        int[] result;

        if(arr[idx] == item){
           result= allIndex(arr,idx+1,item,count+1);
           result[count] = idx;
        }else{
           result = allIndex(arr,idx+1,item,count);
        }

        return result;
    }
}
