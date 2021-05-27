package GenericTree;

import java.util.*;



public class GenericTree {

    Scanner sc = new Scanner(System.in);

    private class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private Node root;

    public GenericTree() {
      root = construct(null,-1);
    }

    private Node construct(Node parent,int ith){

        //prompt
        if(parent == null){
            System.out.println("Enter the data for root node ?");
        } else {
            System.out.println("Enter th data for " + ith + " child of " + parent.data + "?");
        }
        //take input for children
        int item = sc.nextInt();

        //create a new node
        Node nn = new Node();

        //update the data
        nn.data=item;

        //prompt
        System.out.println("Enter the number of Children for "+nn.data+" ?");

        //take input for children
        int noc = sc.nextInt();

        //loop
        for(int i=0;i<noc;i++){

            Node child = construct(nn,i);
            nn.children.add(child);
        }

        return nn;
    }

    public void display(){
        display(root);
    }

    private void display(Node node){

        //self work
        String str = node.data+ " -> ";
        for(Node child : node.children){
            str +=child.data +" ";
        }
        str +=".";
        System.out.println(str);

        //smaller problem
        for(Node child : node.children){
            display(child);
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){

        int totalSize=0;
        for(Node child : node.children){
            int cs = size(child);
            totalSize += cs;
        }

        return totalSize+1;
    }

    public  int max(){
        return max(root);
    }

    private int max(Node node){

        int totalMax = node.data;
        for(Node child : node.children){
            int childMax = max(child);
            totalMax=Math.max(totalMax,childMax);
        }

        return totalMax;
    }

    public boolean find(int item){
        return find(root,item);
    }

    private boolean find(Node node,int item){

        if(node.data==item)
            return true;

        for(Node child : node.children){

            boolean childAns = find(child,item);
            if(childAns)
                return true;
        }

        return false;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node){

        int totalHeight=-1; // will initialize with -1 instead of 0 because if we initialize with zero , then the leaf node returns 1(it should actually return 0)

        for(Node child : node.children){
            int childHeight = height(child);
            totalHeight = Math.max(totalHeight,childHeight);
        }

        return totalHeight+1;
    }

    public void mirror(){
        mirror(root);
    }

    private void mirror(Node node){

        int i=0, j=node.children.size()-1;
        while(j>=i){
            Node temp = node.children.get(i);
            node.children.set(i,node.children.get(j));
            node.children.set(j,temp);
            i++;
            j--;
        }

        for(Node child : node.children){
            mirror(child);
        }


    }

    public void printAtLevel(int level){
        printAtLevel(root,level,0);
    }
    private void printAtLevel(Node node,int level,int count){

        if(count==level){
            System.out.println(node.data);
            return;
        }

        for(Node child : node.children){
            printAtLevel(child,level,count+1);
        }
    }


    public void linearize(){
        linearize(root);
    }

    private void linearize(Node node){

        for(Node child : node.children){
            linearize(child);
        }

        //self work
        while(node.children.size() >1){
            Node temp = node.children.remove(1);
            Node tail = getTail(node.children.get(0));
            tail.children.add(temp);
        }

    }
    private Node getTail(Node node){
        if(node.children.size()==0)
            return node;

        return getTail(node.children.get(0));
    }


    //traversals
    public void preorder(){
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node){
        System.out.print(node.data+" ");

        for(Node child : node.children){
            preorder(child);
        }
    }

    public void postorder(){
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node){

        for(Node child : node.children){
            postorder(child);
        }

        System.out.print(node.data+" ");
    }

    public void levelOrder(){

        Queue<Node> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()){
            //remove
            Node removeNode = que.remove();
            //print
            System.out.print(removeNode.data+" ");

            //enqueue child
            for(Node child : removeNode.children){
                que.add(child);
            }

        }

    }

    public void levelOrderLineWise(){

        Queue<Node> mainQueue = new LinkedList<>();
        Queue<Node> childQueue = new LinkedList<>();
        mainQueue.add(root);

        while (!mainQueue.isEmpty()){
            //remove
            Node removeNode = mainQueue.remove();
            //print
            System.out.print(removeNode.data+" ");

            //enqueue child
            for(Node child : removeNode.children){
                childQueue.add(child);
            }

            if(mainQueue.isEmpty()){
                mainQueue = childQueue;
                childQueue = new LinkedList<>();
                System.out.println();
            }

        }

    }

    public void levelOrderZigZag(){
        Stack<Node> mainStack = new Stack<>();
        Stack<Node> childStack = new Stack<>();
        mainStack.push(root);
        int count =0;

        while(!mainStack.isEmpty()){
            Node removeNode = mainStack.pop();

            System.out.print(removeNode.data+" ");


            //child
            if(count % 2 == 0){
                for(Node child : removeNode.children){
                    childStack.push(child);
                }
            }else{
                for(int i=removeNode.children.size()-1;i>=0;i--){
                    childStack.push(removeNode.children.get(i));
                }
            }


            if(mainStack.isEmpty()){
                System.out.println();
                count++;
                mainStack = childStack;
                childStack = new Stack<>();
            }
        }
    }

}
