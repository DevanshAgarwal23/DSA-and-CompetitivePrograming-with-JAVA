package DisjointSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisjointSetBySize {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSetBySize(int n){
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }


    }

    public int findUParent(int node){
        if(node == parent.get(node)) return node;

        int uParent = findUParent(parent.get(node));
        parent.set(node, uParent);
        return parent.get(node);
    }

    public void union(int a, int b){
        int uParentA = findUParent(a);
        int uParentB = findUParent(b);

        if(uParentA == uParentB) return;

        if(size.get(uParentA) < size.get(uParentB)){
            parent.set(uParentA, uParentB);
            size.set(uParentB, size.get(uParentA) + size.get(uParentB));
        }else{
            parent.set(uParentB, uParentA);
            size.set(uParentA, size.get(uParentA) + size.get(uParentB));
        }
    }
}
