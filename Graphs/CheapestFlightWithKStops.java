package Graphs;

// BFS Good Question

import java.util.*;

class Tuple {
    int stops;
    int node;
    int cost;

    public Tuple(int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

class Pair {
    int node;
    int cost;

    public Pair(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

public class CheapestFlightWithKStops {

    public int cheapestFlightWithKStops(int cities, int[][] flights, int src, int dest, int k){
        int n = flights.length;
        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0;i<cities;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new ArrayDeque<>();
        q.add(new Tuple(0, src, 0));
        int[] totalCost = new int[n];  // distance array in bfs
        Arrays.fill(totalCost, (int) 1e9);

        totalCost[src] = 0;

        while(!q.isEmpty()){
            Tuple it = q.poll();
            int stops = it.stops;
            int node = it.node;
            int cost = it.cost;

            if(stops >k) continue;
            for(Pair nbr : adj.get(node)){
                int adjNode = nbr.node;
                int adjCost = nbr.cost;

                if(cost+adjCost < totalCost[adjNode] && stops<=k){
                    totalCost[adjNode] = cost + adjCost;
                    q.add(new Tuple(stops+1, adjNode, totalCost[adjNode]));
                }
            }
        }

        if(totalCost[dest] == (int) 1e9) return -1;

        return totalCost[dest];
    }

}
