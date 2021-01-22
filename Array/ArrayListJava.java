package Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

//will see some basic methods that comes inbuilt in ArrayList Class
// and some methods that we can apply on ArrayList using Collection class


public class ArrayListJava {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr2.add(33);
        arr2.add(22);
        arr2.add(2);
        arr2.add(66);
        arr2.add(44);
        arr2.add(38);

        arr.add(93);
        arr.add(44);
        arr.add(24);
        arr.add(66);
        arr.add(24);
        arr.add(388);
        //traversing arraylist using for each
        for(int val : arr)
            System.out.print(val + " ");

        System.out.println();

        //traversing using iterator
        Iterator<Integer> i = arr.listIterator();
        while(i.hasNext()){
            System.out.print(i.next()+"  ");
        }

        System.out.println();
        arr.remove(2);//removes item from index 2
        System.out.println(arr);

        arr.add(69);//add element at last of the list
        System.out.println(arr);
        arr.add(1,90);//add element at specific index
        System.out.println(arr);
        System.out.println(arr.get(3)); // gets element from specific index

        System.out.println(arr.isEmpty());
        System.out.println(arr.equals(arr2));

        System.out.println(arr.contains(44)); //searches element

        //Collections Class in java
        Collections.sort(arr2);
        System.out.println(arr2);

        System.out.println(Collections.binarySearch(arr2,33));
        Collections.reverse(arr);
        System.out.println(arr);





    }
}
