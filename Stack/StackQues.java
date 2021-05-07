package Stack;

import java.util.Stack;

public class StackQues {

    public static void main(String[] args) {
        Stack<Integer> ds = new Stack<>();
        ds.push(10);
        ds.push(20);
        ds.push(30);
        ds.push(40);
        ds.push(50);

//		System.out.println("--- Display Reverse ---");
//		ds.display(); // 50 40 30 20 10
//		displayReverse(ds); // 10 20 30 40 50
//		System.out.println();
//		ds.display(); // 50 40 30 20 10 : stack content is still the same

//		System.out.println("--- Actual Reverse ---");
//		ds.display(); // 50 40 30 20 10
//		actualReverse(ds, new DynamicStack());
//		ds.display(); // 10 20 30 40 50
//
//		int[][] arr = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 1, 1, 0 } };
//
//		celebrityProblem(arr);

		int[] arr = {80,50,70,30,20,40,90,10,5,35} ;
		stockSpan(arr);
    }


    public static void displayReverse(Stack<Integer> s){
        if(s.isEmpty())
            return;

        int temp = s.pop();

        displayReverse(s);
        System.out.print(temp + " ");
        s.push(temp);
    }

    public void actualReverse(Stack<Integer> s, Stack<Integer> extra){

        if(s.isEmpty()){
            actualReverseHelper(s,extra);
            return;
        }

        extra.push(s.pop());
        actualReverse(s,extra);
    }
    public static void actualReverseHelper(Stack<Integer> s, Stack<Integer> extra){
        if(extra.isEmpty())
            return;

        int temp = extra.pop();
        actualReverseHelper(s,extra);
        s.push(temp);
    }


    public static void celebrityProblem(int[][] arr){
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<arr.length;i++){
            s.push(i);
        }

        while(s.size()!=1){
            int a=s.pop();
            int b=s.pop();

            //a knows b: a cant be a celeb
            if(arr[a][b] == 1){
                s.push(b);
            } else{ //a doesn't knows b : b cant be a celeb
                s.push(a);
            }

        }

        int candidate = s.pop();

        for( int i=0;i<arr.length;i++){

            if(i!=candidate){
                if(arr[candidate][i] ==1 || arr[i][candidate]==0 ){
                    System.out.println("No Celebs");
                    return;
                }
            }

        }

        System.out.println(candidate +" is a celeb");

    }

    public static void nextGreaterElement(int[] arr){
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i=1;i<arr.length;i++){
            while (!s.isEmpty() && arr[i]>s.peek()){
                System.out.println(s.pop()+" --> "+arr[i]);
            }
            s.push(arr[i]);
        }

        while(!s.isEmpty())
            System.out.println(s.pop()+" --> -1");
    }

    // same approach , just to print ans in proper order
    public static void nextGreaterElement1(int[] arr) {

        int[] ans = new int[arr.length] ;

        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < arr.length; i++) {

            while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
                ans[s.pop()] =  arr[i];
            }

            s.push(i);
        }

        while (!s.isEmpty()) {
            ans[s.pop()] = -1 ;
        }

        for(int i = 0 ; i < ans.length ; i++)
            System.out.println(arr[i] + " -> " + ans[i]);

    }



    public static void stockSpan(int[] arr){
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[arr.length];

        for(int i=0; i<arr.length;i++){

            while(!s.isEmpty() && arr[i]>arr[s.peek()])
                s.pop();

            if(s.isEmpty())
                ans[i] =i+1;
            else
                ans[i] = i-s.peek();

            s.push(i);
        }

        for(int val:ans)
            System.out.print(val+" ");
        System.out.println();
    }


}
