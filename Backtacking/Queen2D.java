package Backtacking;

public class Queen2D {

    public static void main(String[] args) {
       // combinationBox(new boolean[2][2],0,0,0,2,"");
        combinationBoxExtraCall( new boolean[2][2],0,0,0,2,"");

    }

    public static void combinationBox(boolean[][] boxes,int row, int col,int qpsf,int tq,String ans){
        //+ve Base Case
        if(qpsf==tq){
            System.out.println(ans);
            return;
        }

        // manually variable change
        if(col == boxes[0].length){
            row++;
            col=0;
        }

        //-ve base case
        if(row == boxes.length){
            return;
        }

        //place
        boxes[row][col]=true;
        combinationBox(boxes,row,col+1,qpsf+1,tq,ans+"("+row+"--"+col+")");
        boxes[row][col]=false;

        //not placed
        combinationBox(boxes,row,col+1,qpsf,tq,ans);
    }


    public static void combinationBoxExtraCall(boolean[][] boxes,int row, int col,int qpsf,int tq,String ans){
        //+ve Base Case
        if(qpsf==tq){
            System.out.println(ans);
            return;
        }

        // extra recursive call
        if(col == boxes[0].length){
           combinationBoxExtraCall(boxes,row+1,0,qpsf,tq,ans);
           return;
        }

        //-ve base case
        if(row == boxes.length){
            return;
        }

        //place
        boxes[row][col]=true;
        combinationBoxExtraCall(boxes,row,col+1,qpsf+1,tq,ans+"("+row+"--"+col+")");
        boxes[row][col]=false;

        //not placed
        combinationBoxExtraCall(boxes,row,col+1,qpsf,tq,ans);
    }

}
