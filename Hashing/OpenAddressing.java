package Hashing;
//Linear Probing Method
class MyHashClass {
    int[] arr;
    int cap,size;
    MyHashClass(int cap){
        this.cap=cap;
        arr = new int[cap];
        size=0;
        for(int i=0;i<cap;i++) {
            arr[i]=-1;
        }
    }
    int hash(int k){
        return k % cap;
    }
    boolean search(int k){
        int h = hash(k);
        int i = h;
        while(arr[i] != -1){
            if(arr[i] == k) return true;

            i = (i+1)%cap; //for implementing the loop in circular fashion

            if(i==h) return false;
        }
        return false;
    }
    void insert(int k){
        if(size==cap){
            System.out.println("Hash Table is full");
        }
        int i = hash(k);

        while (arr[i]!=-1 && arr[i]!= -2 && arr[i]!=k){
            i=(i+1)%cap;
        }

        if(arr[i]==k){
            System.out.println("Key is already present in Hash Table");
        }else{
            arr[i]=k;
            size++;
            System.out.println("key added");
        }
    }

    void remove(int k){
        int h = hash(k);
        int i = h;
        while(arr[i] != -1){
            if(arr[i] == k) {
                arr[i] = -2; // here -2 specifies that key is deleted not that the arr block is empty
                System.out.println("Key deleted");
            }
            i = (i+1)%cap; //for implementing the loop in circular fashion

            if(i==h) {
                System.out.println("key do not exist in table ");
            }
        }

    }


}


public class OpenAddressing {

    public static void main(String[] args){
        MyHashClass mh = new MyHashClass(7);
        mh.insert(10);
        mh.insert(20);
        mh.insert(15);
        mh.insert(7);
        System.out.println(mh.search(10));
        mh.remove(15);
        System.out.println(mh.search(15));
    }
}
