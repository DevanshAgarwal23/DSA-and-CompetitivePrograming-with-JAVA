package Backtacking;

public class NQueen {
    public static void main(String[] args) {
        boolean[][] boxes = new boolean[4][4 ];
        NQueenCombination(boxes,0,0,0, boxes.length, "");
    }

    public static void NQueenCombination(boolean[][] boxes, int row, int col, int qpsf, int tq, String ans) {
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


        if (isItSafeToPlaceQueen(boxes, row, col)) {
            //place
            boxes[row][col] = true;
            NQueenCombination(boxes, row+1, 0, qpsf + 1, tq, ans + "(" + row + "--" + col + ")");
            boxes[row][col] = false;

        }

        //not placed
        NQueenCombination(boxes, row, col + 1, qpsf, tq, ans);
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
