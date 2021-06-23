package Hashing.HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HashSetDemo {
    public static  void main (String[] args){
        HashSet<String> h = new HashSet<>();
        //LinkedHashSet<String> h = new LinkedHashSet<>();
        h.add("dev");
        h.add("course");
        h.add("coding");

        System.out.println(h.size());
        System.out.println(h);
        h.remove("course");
        System.out.println(h.size());
        System.out.println(h.contains("coding"));
        System.out.println(h.contains("ide"));

        //traversing using iterator
        Iterator<String> i = h.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }

        //traversing in HashSet using forEach loop
        for(String s : h){
            System.out.println(s);
        }
        h.clear();
        System.out.println(h.size());
        System.out.println(h.isEmpty());
    }
}
