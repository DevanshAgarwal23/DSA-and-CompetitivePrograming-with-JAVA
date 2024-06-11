package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    private PriorityQueue<Integer> rightMinHeap;
    private PriorityQueue<Integer> leftMaxHeap;

   public FindMedianFromDataStream(){
       rightMinHeap = new PriorityQueue<>();
       leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
   }

    public void addNum(int num) {
        if(leftMaxHeap.isEmpty() || num < leftMaxHeap.peek()){
            leftMaxHeap.add(num);
        }else{
            rightMinHeap.add(num);
        }

        // Always maintain leftMaxHeap size one greater than rightMaxHeap size
        // or keep both size equal

        if(Math.abs(leftMaxHeap.size()-rightMinHeap.size()) > 1){
            rightMinHeap.add(leftMaxHeap.poll());
        }else if(leftMaxHeap.size() < rightMinHeap.size()){
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        if(leftMaxHeap.size() == rightMinHeap.size()){
            return (double)(leftMaxHeap.peek() + rightMinHeap.peek())/2;
        }

        return leftMaxHeap.peek();
    }
}
