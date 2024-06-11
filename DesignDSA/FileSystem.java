package DesignDSA;


// In Memory File System.

/*Design a data structure that simulates an in-memory file system.

Implement the FileSystem class:

1. FileSystem() Initializes the object of the system.
2.  List<String> ls(String path)
        - If path is a file path, returns a list that only contains this file's name.
        - If path is a directory path, returns the list of file and directory names in this directory.
3. The answer should in lexicographic order.
4. "void mkdir(String path)" :-  Makes a new directory according to the given path.
                                The given directory path does not exist.
                                If the middle directories in the path do not exist, you should create them as well.
5." void addContentToFile(String filePath, String content)":-
                            - If filePath does not exist, creates that file containing given content.
                            - If filePath already exists, appends the given content to original content.
6. "String readContentFromFile(String filePath)":-  Returns the content in the file at filePath.*/


public class FileSystem {
    public static void main(String[] args) {
        String s = " bdbcj ";
        s = s.trim();
        //System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("21474836474"));

    }
    static public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        boolean isNegativeNumber = false;
        int index =0;
        if(s.charAt(index)=='-' || s.charAt(index) == '+'){
            isNegativeNumber = s.charAt(index)=='-';
            index++;
        }

        // we have handled case 1, 2 till now.
        // need to handel for case 3 & 4 from this point
        int ans = 0;
        while(index < s.length()){
            if(!Character.isDigit(s.charAt(index))) break;

            int digit = s.charAt(index) - '0';
            System.out.println(digit);

            // check for integer overFlow
            if(ans>Integer.MAX_VALUE/10 || ans==Integer.MAX_VALUE/10 && Integer.MAX_VALUE %10 < digit){
                return isNegativeNumber ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans *10 + digit;
            //System.out.println(ans);
            index++;
        }

        return isNegativeNumber ? ans * -1 : ans;
    }
}
