package Array;

//we will see some basic functionality of arrays
// and some method that we can use on array using Arrays Class in Java

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class ArrayBasic {


    public static void main(String[] args){
        //Declaration
        Integer[] arr;
        //Initialization
        arr = new Integer[5];
        //declaration and initialization
        int[] arr2 = new int[5];
        Integer[] arr3 = {10,2,32,22,15};
        //Note:- Remember, in java array is always Heap allocated,
                // only address od array is stored in Stack

       //for loop for inserting value in array
        for(int i=0; i<arr.length;i++){
            arr[i] = (i+100);
        }
        for(int i=0; i<arr2.length;i++){
            arr2[i] = (200-i);
        }

        //Arrays Class in Java (some important methods)
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        Arrays.sort(arr,new ReverseOrder()); //sorting using your own comparator
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.equals(arr,arr3));

        Collections.reverse(Arrays.asList(arr3));//we can use asList on arrays of non-primitive data type
        System.out.println(Arrays.toString(arr3));

    }



}

class ReverseOrder implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
