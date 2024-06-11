package DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n){
        for(int i=0; i<=n;i++){
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUParent(int node){
        if(node == parent.get(node)) return node;

        int ultimateParent = findUParent(parent.get(node));
        parent.set(node, ultimateParent);

        return parent.get(node);
    }

    public void unionByRank(int a, int b){

        int uParentA = findUParent(a); // ultimate parent of a , root of tree which a is part off
        int uParentB = findUParent(b);

        if(uParentA == uParentB) return;

        if(rank.get(uParentA) < rank.get(uParentB)){
            parent.set(uParentA, uParentB);
        } else if (rank.get(uParentB) < rank.get(uParentA)) {
            parent.set(uParentB, uParentA);
        }else {
            parent.set(uParentB, uParentA);
            int newRank = rank.get(uParentA)+1;
            rank.set(uParentA, newRank);
        }
    }
}
