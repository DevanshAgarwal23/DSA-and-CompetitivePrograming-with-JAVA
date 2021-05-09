package Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueuesQues {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

//        System.out.println(queue);
////        displayReverse(queue,0);
//        actualReverse(queue);
//        System.out.println(queue);


        int[] arr = {10,-1,-8,6,30,40,50,60} ;

        firstNegativeWindow(arr, 3);

    }


    public static void displayReverse(Queue<Integer> q,int count){

        if(q.size()== count)
            return;

        int temp = q.poll();

        q.add(temp);

        displayReverse(q,count+1);

        System.out.print(temp+ " ");


    }

   public static void actualReverse(Queue<Integer> q){
        if(q.isEmpty())
            return;

        int temp = q.poll();

        actualReverse(q);

        q.add(temp);
   }

   public static  void  firstNegativeWindow(int[] arr, int k){
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<k; i++){
            if(arr[i]<0)
                q.add(i);
        }

        if(q.isEmpty())
            System.out.println(0);
        else
            System.out.println(arr[q.peek()]);

        for(int i=k;i<arr.length;i++){

            //remove
            if(!q.isEmpty()&&q.peek()==i-k)
                q.remove();

            //add
            if(arr[i]<0)
                q.add(i);

            //ans
            if(q.isEmpty())
                System.out.println(0);
            else
                System.out.println(arr[q.peek()]);
        }

   }
}
