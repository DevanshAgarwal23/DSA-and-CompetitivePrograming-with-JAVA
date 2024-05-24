package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MinQueue {
    Queue<Integer> q;
    Deque<Integer> dq;

    public MinQueue()
    {
        q = new LinkedList<>();
        dq = new ArrayDeque<>();
    }

    void enque(int data)
    {
        // remove all elements from
        // from deque which are greater
        // than the current element 'data'
        while (!dq.isEmpty() && dq.getLast() > data) {
            dq.removeLast();
        }
        // If queue is empty then
        // while loop is skipped.
        dq.addLast(data);
        q.add(data);
    }

    void deque()
    {
        // If min element is present
        // at front of queue
        if (dq.getFirst() == q.peek()) {
            dq.removeFirst();
        }
        q.remove();
    }

    // Method to get min element in Queue
    int getMin() throws Exception
    {
        // If queue is Empty, return Exception
        if (q.isEmpty())
            throw new Exception("Queue is Empty");
        else
            return dq.getFirst();
    }


    public static void main(String[] args) throws Exception {
        MinQueue arr = new MinQueue();
        arr.enque(1);
        arr.enque(3);
        arr.enque(4);
        System.out.println(arr.getMin());
        arr.deque();
        arr.enque(2);
        System.out.println(arr.getMin());
    }
}
