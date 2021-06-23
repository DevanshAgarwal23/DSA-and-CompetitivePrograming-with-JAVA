package Hashing.HashSet;

import java.util.ArrayList;
import java.util.LinkedList;


class MyHash{
    int BUCKET;
    ArrayList<LinkedList<Integer>> table;

    MyHash(int b){
        this.BUCKET = b;
        this.table = new ArrayList<LinkedList<Integer>>();
        for(int i=0;i<b;i++){
            table.add(new LinkedList<Integer>());
        }
    }

    void insert(int k){
        int i = k % BUCKET;
        table.get(i).add(k);
    }

    void delete(int k){
        int i = k % BUCKET;
        table.get(i).remove((Integer) k); // we have to type cast manually because remove function has two implementation in java when it takes primitive type (int) it removes element at that index and when it takes Object (Integer) then it removes that object
    }

    boolean search(int k) {
        int i = k % BUCKET;
       return table.get(i).contains(k);
    }
}



public class Chaining {

    public static void main(String[] args){
        MyHash mh = new MyHash(7);
        mh.insert(10);
        mh.insert(20);
        mh.insert(15);
        mh.insert(7);
        System.out.println(mh.search(10));
        mh.delete(15);
        System.out.println(mh.search(15));
    }
}
