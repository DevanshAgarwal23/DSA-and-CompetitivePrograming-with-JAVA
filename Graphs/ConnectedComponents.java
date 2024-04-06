package Graphs;

import java.util.*;
public class ConnectedComponents {

    private void dfs(int start, Map<Integer, List<Integer>> adjMap, List<Integer> visited) {
       if(visited.contains(start)) return;

       visited.add(start);

       for(int nbr : adjMap.get(start)){
            if(!visited.contains(nbr)) dfs(nbr, adjMap, visited);
       }
    }
    public int countComponents(int n, int[][] edges) {
       Map<Integer,List<Integer>> adj = new HashMap<>();

       for(int i =0; i<n; i++){
            adj.put(i, new ArrayList<>());
       }


       for(int[] edge : edges){
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
       }

        List<Integer> visited = new ArrayList<>();

        int count=0;

        for(int src : adj.keySet()){
            if(!visited.contains(src)){
                dfs(src, adj, visited);
                count++;
            }
        }

        return count;

    }
}
