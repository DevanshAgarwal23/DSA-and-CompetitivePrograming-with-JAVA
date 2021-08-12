package Backtacking;

import java.util.*;

public class SplitArrayIntoFibonacciSequence {
    public static void main(String[] args) {
        System.out.println(splitIntoFibonacci("0123"));
    }

    public static List<List<Integer>> splitIntoFibonacci(String num) {

        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        splitFib(num,temp,ans);

        return ans;
    }


    public static void splitFib(String ques,List<Integer> temp,List<List<Integer>> ans){

        if(ques.length() == 0){

            if(temp.size() >= 3)
                ans.add(new ArrayList<>(temp));

            return;
        }

        for(int i=1;i<=ques.length();i++){
            String part = ques.substring(0,i);
            String roq = ques.substring(i);

            if(isInRange(part)){
                int num = Integer.parseInt(part);

                if(isFibonacciSeq(temp,num) && noLeadingZero(part)){
                    temp.add(num);
                    splitFib(roq,temp,ans);
                    temp.remove(temp.size()-1);
                }
            }

        }
    }

    public static boolean isInRange(String str){

        if(str.length() >= 11)
            return false;

        return Long.parseLong(str) <= Math.pow(2,31) -1;
    }

    public static boolean noLeadingZero(String str){

        if(str.length() <= 1)
            return true;


        return str.charAt(0) != '0';
    }

    public static boolean isFibonacciSeq(List<Integer> temp, int num){

        if(temp.size() <= 1) return true;

        int lastNum = temp.get(temp.size()-1);
        int lastSecondNum  = temp.get(temp.size()-2);


        return lastNum+lastSecondNum == num;

    }

}
