package Backtacking;

import java.util.Scanner;
import java.util.*;
public class  Queen1D {

    static int count =0;
    public static void main(String[] args) {
        //queenPermutation(new boolean[4],0,2,"");
        // queenCombination(4,0,2,"",-1);
          queenCombinationBoxResp(new boolean[4],0,0,2," ");

    }

    public static void queenPermutation(boolean[] boxes,int qpsf,int tq,String ans) {

        if(qpsf == tq){
            count++;
            System.out.println(count+"."+ans);
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if (!boxes[i]) {
                boxes[i] = true;
                queenPermutation(boxes, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ");
                boxes[i] = false;
            }

        }
    }

    public static void queenCombination(int boxes,int qpsf,int tq,String ans,int lastBoxUsed) {

        if(qpsf == tq){
            count++;
            System.out.println(count+"."+ans);
            return;
        }

        for (int i = lastBoxUsed+1 ; i < boxes; i++) {
            queenCombination(boxes, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ",i);
        }
    }

    public static void queenCombinationBoxResp(boolean[] boxes,int col,int qpsf,int tq,String ans){

        //+ve Base Case
        if(qpsf==tq){
            System.out.println(ans);
            return;
        }

        //-ve base case
        if(col == boxes.length){
            return;
        }


        //place
        boxes[col]=true;
        queenCombinationBoxResp(boxes,col+1,qpsf+1,tq,ans+"b"+col+"q"+qpsf+" ");
        boxes[col]=false;

        //not placed
        queenCombinationBoxResp(boxes,col+1,qpsf,tq,ans);
    }

}
