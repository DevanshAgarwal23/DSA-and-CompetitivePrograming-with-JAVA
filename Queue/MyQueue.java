package Queue;


// we are making circular queue
public class MyQueue {

    protected int[] arr;
    protected int front;
    protected int size;

    //constructors

    public MyQueue(){
        this.arr = new int[5];
        front = 0;
        size=0;
    }

    public MyQueue(int cap){
        this.arr = new int[cap];
        this.front=0;
        this.size=0;
    }

    //methods

    public void  enqueue(int item) throws Exception {
        if(isFull())
            throw new Exception("Queue Is Empty");

        int idx = (front + size) % arr.length;
        arr[idx] = item;


        size++;

    }

    public int dequeue() throws Exception {

        if(isEmpty())
            throw new Exception("Queue is Empty");

        int temp = arr[front];
        arr[front] = 0;

        front= (front+1)%arr.length;
        size--;

        return temp;
    }

    public int getFront() throws Exception {
        return arr[front];
    }

    public int size() {
        return size;
    }

    public boolean isFull(){
        return size()==arr.length ;
    }

    public boolean isEmpty() {
        return size() ==0;
    }

    public void display(){

        System.out.println("----------------");
        for(int i=0;i<size;i++){
            int idx = (front+i)%arr.length;
            System.out.print(arr[idx]+"");
        }
        System.out.println("----------------");
    }

}
