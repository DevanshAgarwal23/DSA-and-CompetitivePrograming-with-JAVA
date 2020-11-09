package LinkedList;

class Node{
    int data;
    Node next;
    //constructor
    Node(int data){
        this.data = data;
    }
}

class MySinglyLinkedList{
    Node head;

    void insertBegin(int x){
        Node temp = new Node(x);
        temp.next = head;
        head=temp;
    }
    void insertEnd(int x){
        Node temp = new Node(x);
        if(head==null){
            head = temp;
            return;
        }
        Node curr= head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=temp;
    }
    void printList(){
        Node curr = head;
        while(curr!=null){
            System.out.println(curr.data);
            curr=curr.next;
        }
    }

}


public class SLL {

    public static void main(String[] args){
        MySinglyLinkedList ll = new MySinglyLinkedList();
        ll.insertBegin(12);
        ll.insertBegin(22);
        ll.insertEnd(33);
        ll.printList();
    }
}
