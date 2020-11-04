package Stack;
//Stack implementation using basic Array
class MyStack  {
    int[] arr;
    int cap;
    int top;
//constructor
    MyStack(int cap){
        this.top=-1;
        this.cap = cap;
        arr = new int[cap];
    }

    void push(int x){
        if(top==cap){
            throw new ArrayIndexOutOfBoundsException();
        }
        top++;
        arr[top]=x;
    }
     int pop() {
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        int res = arr[top];
        top--;
        return res;
    }
    int peek(){
        return arr[top];
    }
    int size(){
        return top+1;
    }
    boolean isEmpty(){
        return (top==-1);
    }
    void printStack(){
      for(int i=top;i>=0;i--){
          System.out.println(arr[i]);
      }
    }

}


public class ArrayStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.printStack();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        //stack.printStack();



    }
}
