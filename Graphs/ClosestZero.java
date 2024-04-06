package Graphs;
import java.util.*;

//Leetcode Name:- 01 Matrix (542)
public class ClosestZero {

    public int[][] updateMatrix(int[][] mat) {

        Queue<int[]> q = new LinkedList<>();

        

        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.add(new int[]{i,j});
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }


        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        /*
            We have not used a visited array in this, as an optimization.
            We can check if the node is visited or not by checking its value in matrix
            (because we are updating the matrix value for non zero values,
            and all the zero values cell are pushed at once in the queue)
        **/
        while(!q.isEmpty()){
            int[] cell = q.remove();
            for(int[] di : dir){
                int r = cell[0]+di[0];
                int c = cell[1]+di[1];

                if(!isValid(r,c, mat.length, mat[0].length)) continue;

                if(mat[r][c] > mat[cell[0]][cell[1]]+1){
                    q.add(new int[]{r,c});
                    mat[r][c] = mat[cell[0]][cell[1]]+1;
                }
            }
        }

        return mat;
    }

    boolean isValid(int r, int c, int n, int m){
        if(r>=0 && r<n && c>=0 && c<m) return true;

        return false;
    }

}
