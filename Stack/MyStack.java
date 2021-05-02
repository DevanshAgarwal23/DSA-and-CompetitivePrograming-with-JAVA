package Stack;



//Stack implementation



public class MyStack  {
    protected int[] arr;
    protected int top;

    //constructor
    public MyStack() {
        this.arr = new int[5];
        this.top=-1;
    }
    public MyStack(int cap){
        this.top=-1;
        this.arr = new int[cap];
    }

    void push(int x) throws Exception {
        if(isFull()){
            throw new ArrayIndexOutOfBoundsException();
        }
        top++;
        arr[top]=x;
    }
     int pop() throws Exception {
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        int res = arr[top];
        top--;
        return res;
    }
    int peek() throws Exception{
        if(isEmpty())
            throw new Exception("Stack is Empty");

        return arr[top];
    }
    int size() {
        return top+1;
    }
    boolean isEmpty(){
        return (top==-1);
    }
    boolean isFull(){
        return size()==arr.length;
    }

    void display(){

        System.out.println("-----------------");

        for(int i=top;i>=0;i--){
          System.out.print(arr[i]+"");
        }

        System.out.println("-----------------");
    }

}



