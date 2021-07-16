package Backtacking;

public class NKnight {
    public static void main(String[] args) {
        nKnights(new boolean[3][3],0,0,0,3,"");
    }

   public static void nKnights(boolean[][] boxes,int row,int col,int kpsf,int tk,String ans){

        // +ve Base case
       if(kpsf == tk){
           System.out.println(ans);
           return;
       }

       // manually changing variable
       if(col == boxes[0].length){
           row ++;
           col=0;
       }

       // -ve Base case
       if(row == boxes.length)
           return;




        //placed
       if(isItSafeToPlaceKnight(boxes,row,col)){
           boxes[row][col] = true;
           nKnights(boxes,row,col+1,kpsf+1,tk,ans+"("+row+"--"+col+")");
           boxes[row][col] = false;
       }


        //not placed
       nKnights(boxes,row,col+1,kpsf,tk,ans);
   }

   public static boolean isItSafeToPlaceKnight(boolean[][] boxes,int row,int col){

        int[] rowArr = {-1,-2,-2,-1};
        int[] colArr = {-2,-1,1,2};

        for(int i=0; i< rowArr.length;i++){

            int r = row+rowArr[i];
            int c = col+colArr[i];

            if(r >= 0 && c >= 0 && c < boxes[0].length){
                if(boxes[r][c]){
                    return false;
                }
            }
        }

        return true;
   }


}
