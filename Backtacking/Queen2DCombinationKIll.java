package Backtacking;

public class Queen2DCombinationKIll {
    public static void main(String[] args) {
        combinationBox2DKill(new boolean[3][4],0,0,0,3,"");
    }

    public static void combinationBox2DKill(boolean[][] boxes, int row, int col, int qpsf, int tq, String ans) {
        //+ve Base Case
        if (qpsf == tq) {
            System.out.println(ans);
            return;
        }

        // manually variable change
        if (col == boxes[0].length) {
            row++;
            col = 0;
        }

        //-ve base case
        if (row == boxes.length) {
            return;
        }

        //place
        if (isItSafeToPlaceQueen(boxes, row, col)) {
            boxes[row][col] = true;
            combinationBox2DKill(boxes, row, col + 1, qpsf + 1, tq, ans + "(" + row + "--" + col + ")");
            boxes[row][col] = false;

        }

        //not placed
        combinationBox2DKill(boxes, row, col + 1, qpsf, tq, ans);
    }

    static boolean isItSafeToPlaceQueen(boolean[][] boxes,int row,int col){

        //vertically upward
        int r = row-1;
        int c = col;

        while(r >= 0){
            if(boxes[r][c])
                return false;

            r--;
        }

        //horizontally left
        r = row;
        c= col-1;

        while(c >= 0){
            if(boxes[r][c])
                return false;

            c--;
        }

        //diagonally left
        r = row -1;
        c = col -1;

        while(r >=0 && c >= 0){
            if(boxes[r][c])
                return false;

            r--;
            c--;
        }

        //diagonally right
        r = row -1;
        c = col +1;
        while(r >= 0 && c < boxes[0].length) {
            if(boxes[r][c])
                return false;

            r--;
            c++;
        }


        return true;
    }
}