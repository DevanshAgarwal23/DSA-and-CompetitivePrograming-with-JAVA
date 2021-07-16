package Recursion;

public class printRecursion {


    /*
        This Method is also called in-op method.
    */


    public static void main(String[] args) {
//        subsequencesAscii("abc","");
//        mazePath(0,0,2,2,"");
//        climbingStairs(0,5,"");
        validParenthesis(0,0,3,"");
    }


    public static void subsequences (String ques, String ans) {

        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);//a
        String roq = ques.substring(1);//bc

        subsequences(roq, ans); //bc , ""
        subsequences(roq, ans+ch); //bc,a

    }

    public static void subsequencesAscii (String ques, String ans) {

        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);//a
        String roq = ques.substring(1);//bc

        subsequencesAscii(roq, ans); //bc , ""
        subsequencesAscii(roq, ans+ch); //bc,a
        subsequencesAscii(roq,ans+(int)ch);

    }


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

    public static void keypadCombination(String ques, String ans){

        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        String code = getCode(ch);

        for(int i=0; i< code.length(); i++){
            keypadCombination(roq,ans+code.charAt(i));
        }
    }


    public static void permutation1(String ques, String ans){

        if(ques.length()==0){
            System.out.println(ans);
            return;
        }


        for(int i=0; i<ques.length(); i++){
            String roq = ques.substring(0,i)+ques.substring(i+1);
            permutation1(roq,ans+ques.charAt(i));

        }
    }

    public static void permutation2(String ques,String ans){

        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        for(int i=0; i<=ans.length();i++){
            permutation2(roq,ans.substring(0,i)+ch+ans.substring(i));
        }
    }

    public static  void coinToss(int n , String ans){
        if(n==0){
            System.out.println(ans);
            return;
        }

        coinToss(n-1, ans+"H");
        coinToss(n-1 , ans+"T");
    }

    public static void coinTossWithoutConsecutiveHeads(int n , String ans, boolean isLastHeadIncluded){
        if(n==0){
            System.out.println(ans);
            return;
        }

        if(isLastHeadIncluded){
            coinTossWithoutConsecutiveHeads(n-1,ans+"T",false);
        }else{
            coinTossWithoutConsecutiveHeads(n-1,ans+"H",true);
            coinTossWithoutConsecutiveHeads(n-1,ans+"T",false);
        }

    }

    public static void mazePath(int cr,int cc,int er,int ec,String ans){
        //+ve base case
        if(cr==er && cc==ec){
            System.out.println(ans);
            return;
        }

        //-ve base case
        if(cr>er || cc>ec){
            return;
        }

        mazePath(cr,cc+1,er,ec,ans+"H");//horizontal call
        mazePath(cr+1,cc,er,ec,ans+"V");//vertical call
    }

    public static void climbingStairs(int curr,int n,String ans){
        //+ve base case
        if(curr==n){
            System.out.println(ans);
            return;
        }

        //-ve base case
        if(curr>n){
            return;
        }

        for(int jump=1;jump<=3;jump++){
            climbingStairs(curr+jump,n,ans+jump);
        }
    }


    //Generate Parenthesis or Valid Parenthesis
    public static void validParenthesis(int open,int close,int n,String ans){
        //+ve base case
        if(open==n && close==n){
            System.out.println(ans);
            return;
        }

        //-ve base case
        if(open>n || close>open){
            return;
        }

        validParenthesis(open+1,close,n,ans+"(");
        validParenthesis(open,close+1,n,ans+")");
    }

    //Palindrome Partitioning

    void palindromePartitioning(String ques, String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=1;i<ques.length();i++){
            String part = ques.substring(0,i);
            String roq = ques.substring(i);

            if(isPalindrom(part)){
                palindromePartitioning(roq,ans+part+"");
            }

        }

    }

    boolean isPalindrom(String str){

        int i=0;
        int j=str.length()-1;

        while(i<=j){

            if(str.charAt(i) != str.charAt(j)) return false;

            i++;
            j--;
        }
        return true;
    }


}
