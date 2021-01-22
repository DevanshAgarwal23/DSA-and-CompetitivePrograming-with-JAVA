package String;

public class MyString {

    public static void main(String[] args){
        String str =  "helloo";//literal

        //print
        System.out.println(str);

        //length
        System.out.println(str.length());

        //charAt
        System.out.println(str.charAt(0));
        char ch = str.charAt(2);
        System.out.println(ch);
        System.out.println(str.charAt(str.length()-1));

        //substring
        System.out.println(str.substring(1,3));//el
        System.out.println(str.substring(1,5));//ello
        System.out.println(str.substring(3,4));//l
        System.out.println(str.substring(1,1));//""
        System.out.println(str.substring(1));//ello
        //System.out.println(str.substring(3,7)); //error

        //indexof
        System.out.println(str.indexOf("oo"));//4
        System.out.println(str.indexOf("Ll")); //-1 : is not present

        //lastindexof
        System.out.println(str.lastIndexOf("o")); //5

        //startsWith
        System.out.println(Math.pow(10,2)*2);







    }
}
