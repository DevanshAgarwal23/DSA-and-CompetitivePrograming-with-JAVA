package XProblemSolving;

import java.util.*;
class Solution
{
    public int minStepToReachTarget(int source[], int destination[], int N)
    {

        ArrayList<Node> possiblePlace = new ArrayList<>();
        possiblePlace.add(new Node(1,2));
        possiblePlace.add(new Node(1,-2));
        possiblePlace.add(new Node(-1,2));
        possiblePlace.add(new Node(-1,-2));
        possiblePlace.add(new Node(2,1));
        possiblePlace.add(new Node(2,-1));
        possiblePlace.add(new Node(-2,1));
        possiblePlace.add(new Node(-2,-1));

        Queue<Node> q = new LinkedList<>();
        int[][] visited = new int[N+1][N+1];
        visited[source[0]][source[1]] = 1;
        q.add(new Node(source[0], source[1], 0));

        while(!q.isEmpty()){
            Node cur = q.remove();

            if(cur.row == destination[0] && cur.col == destination[1]) return cur.dist;


            for(Node p: possiblePlace){
                int x =cur.row+p.row;
                int y = cur.col+p.col;

                if(!isValid(x,y,N)) continue;

                if(visited[x][y] != 1){
                    int dist = cur.dist+1;
                    if(x == destination[0] && y == destination[1]) return dist;
                    visited[x][y]=1;
                    q.add(new Node(x,y,dist));
                }

            }
        }

        return -1;

    }

         boolean isValid(int x, int y, int N){
            if(x<N && x>=0 && y<N && y>=0) return true;

            return false;
        }

    class Node {
        int row;
        int col;
        int dist;

        Node(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        Node(int row, int col){
            this.row = row;
            this.col = col;
            this.dist = -1;
        }
    }
}