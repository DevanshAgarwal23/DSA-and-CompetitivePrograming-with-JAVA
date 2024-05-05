package Graphs;

public class SurroundedRegion {
    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        //vertical
        for(int i=0;i<n;i++){
            if(board[i][0] == 'O'){
                dfs(board, i ,0);
            }

            if(board[i][m-1] == 'O'){
                dfs(board, i, m-1);
            }
        }

        for(int i=0; i<m;i++){
            if(board[0][i] == 'O'){
                dfs(board, 0 ,i);
            }

            if(board[n-1][i] == 'O'){
                dfs(board, n-1, i);
            }
        }

        // for(char[] sub : board){
        //     System.out.println(Arrays.toString(sub));
        // }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'A') board[i][j] = 'O';
            }
        }


    }


    void dfs(char[][] grid, int i, int j){
        if(!isValid(grid,i,j)) return;

        if(grid[i][j] != 'O') return;

        int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        grid[i][j] = 'A';

        for(int[] di : dir){
            int r = i+di[0];
            int c = j+di[1];

            dfs(grid, r, c);
        }
    }

    boolean isValid(char[][] mat, int i,int j){
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length) return false;

        return true;
    }
}
