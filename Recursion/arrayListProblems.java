package Recursion;


import java.util.ArrayList;

public class arrayListProblems {

    public static void main(String[] args) {
//        ArrayList<String> cs = climbingStairs(0,5);
//        System.out.println(cs);

//        ArrayList<String> mp = mazePath(0,0,2,2);
//        System.out.println(mp);

        System.out.println(subsequencesAscii("abc"));
    }

    public static ArrayList<String> subsequences(String str){
         if(str.length()==0){
             ArrayList<String> br = new ArrayList<>();
             br.add("");
             return br;
         }

         char ch =  str.charAt(0);//a
         String ros = str.substring(1);//bc
         ArrayList<String> rr = subsequences(ros);//[-,b,c,bc]

        ArrayList<String> fr = new ArrayList<>();

        for(String val : rr){
            fr.add(val);
            fr.add(ch+val);
        }

        return fr;
    }

    public static ArrayList<String> subsequencesAscii(String str){
        if(str.length()==0){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch =  str.charAt(0);//a
        String ros = str.substring(1);//bc
        ArrayList<String> rr = subsequencesAscii(ros);//[-,b,c,bc]

        ArrayList<String> fr = new ArrayList<>();

        for(String val : rr){
            fr.add(val);
            fr.add(ch+val);
            fr.add((int)ch+val);
        }

        return fr;
    }

    //keypad Combination


    //helping function
    public static  String getCode(char ch) {
        if (ch == '1')
            return "abc";
        else if (ch == '2')
            return "def";
        else if (ch == '3')
            return "ghi";
        else if (ch == '4')
            return "jk";
        else if (ch == '5')
            return "lmno";
        else if (ch == '6')
            return "pqr";
        else if (ch == '7')
            return "stu";
        else if (ch == '8')
            return "vwx";
        else if (ch == '9')
            return "yz";
        else if (ch == '0')
            return "@#";
        else
            return "";
    }

    public static ArrayList<String> keypadCombination(String str){

        if(str.length()==0){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        //smallerProblem
        ArrayList<String> rr = keypadCombination(ros);

        //self work
        ArrayList<String> mr = new ArrayList<>();

        String code = getCode(ch);

        for(String val : rr){

            for(int i=0;i<code.length();i++){
                mr.add(code.charAt(i)+val);
            }
        }


        return mr;
    }


    public static ArrayList<String> permutation(String str){

        if(str.length()==0){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        //smallerProblem
        ArrayList<String> rr = permutation(ros);

        //self work
        ArrayList<String> mr =new ArrayList<>();

        for(String val : rr){

            for(int i=0; i<=val.length(); i++){
                mr.add(val.substring(0,i)+ch+str.substring(i));
            }
        }

        return mr;
    }

    public static ArrayList<String> coinToss(int n){
        if(n==0){
            ArrayList<String>  br = new ArrayList<>();
            br.add("");
            return br;
        }

        //sp
        ArrayList<String> rr = coinToss(n-1);

        //self work
        ArrayList<String> mr = new ArrayList<>();

        for(String val : rr){
            mr.add("H"+val);
            mr.add("T"+val);
        }

        return mr;
    }


    // Multiple recursion calls


    public static  ArrayList<String> climbingStairs(int curr, int end){

        // +ve base case
        if(curr == end){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }

        // -ve base case
        if(curr > end){
            ArrayList<String> br = new ArrayList<>();
            return br;
        }


        ArrayList<String> mr = new ArrayList<>();


        for (int jump=1;jump<=3;jump++){

            // smaller problem
            ArrayList<String> rr = climbingStairs(curr+jump,end);

            // self work
            for(String val : rr){
                mr.add(jump + val);
            }
        }



        /* self work
         for(String val : rr1){
             mr.add(1+val);
         }

         for(String val : rr2){
             mr.add(2+val);
         }

         for(String val : rr3){
             mr.add(3+val);
         }
        */


        return mr;
    }


    public static ArrayList<String> mazePath (int cr, int cc, int er, int ec){

        //+ve base case
       if(cr==er && cc==ec){
           ArrayList<String> br = new ArrayList<>();
           br.add("");
           return br;
       }

       //-ve base case
       if(cr>er || cc>ec){
           ArrayList<String> br = new ArrayList<>();
           return br;
       }

        ArrayList<String> mr = new ArrayList<>();

        ArrayList<String> rrh = mazePath(cr,cc+1,er,ec);//horizontal move

        for(String val : rrh){
            mr.add("H"+val);
        }

        ArrayList<String> rrv = mazePath(cr+1,cc,er,ec);//vertical move

        for(String val : rrv){
            mr.add("V"+val);
        }

        return mr;
    }



}
