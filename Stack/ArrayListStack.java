package Stack;

import java.util.ArrayList;

class MyALStack{
    ArrayList<Integer> arr = new ArrayList<>();
    void push(int x){
        arr.add(x);
    }
    int pop(){
       int res=arr.get(arr.size()-1);
       arr.remove(arr.size()-1);
       return res;
    }
    int peek(){
        return arr.get(arr.size()-1);
    }
    boolean isEmpty(){
        return (arr.isEmpty());
    }
    int size(){
        return arr.size();
    }
}


public class ArrayListStack {
    public static void main(String[] args){
        MyALStack stack = new MyALStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
    }
}
