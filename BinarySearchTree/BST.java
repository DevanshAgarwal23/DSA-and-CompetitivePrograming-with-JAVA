package BinarySearchTree;

import BinaryTree.BinaryTree;

import java.util.Arrays;

public class BST {

    private class Node{
        int data;
        Node left;
        Node right;
    }

    private Node root;

    public BST(int[] in){
        root = construct(in,0,in.length-1);
    }

    private Node construct(int[] in,int lo,int hi){
        if(lo>hi)
            return null;

        int mid = (lo+hi)/2;

        Node nn = new Node();
        nn.data = in[mid];

        nn.left = construct(in,lo,mid-1);
        nn.right = construct(in,mid+1,hi);

        return nn;
    }

    public void display(){
        display(root);
    }

    private void display(Node node){

        if(node == null)
            return;

        String str = "";

        if(node.left == null)
            str+=".";
        else
            str+=node.left.data;

        str += " --> "+node.data+" <-- ";

        if(node.right == null)
            str+=".";
        else
            str+=node.right.data;

        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){

        if(node == null)
            return 0 ;

        int ls = size(node.left);
        int rs = size(node.right);

        return ls+rs+1;
    }

    public int max(){
        return max(root);
    }
    private int max(Node node){

        if(node.right == null)
            return node.data;

        return max(node.right);
    }
    public int min(){
        return min(root);
    }
    private int min(Node node){

        if(node.left==null)
            return node.data;

        return min(node.left);
    }

    public boolean find(int data){
        return find(root,data);
    }
    private boolean find(Node node,int data){

        if(node==null)
            return false;

        if(data > node.data){
            return find(node.right,data);
        }else if(data< node.data){
            return find(node.left,data);
        }else{
            return true;
        }
    }




    public void add(int data){
        if(root == null){
            Node nn = new Node();
            nn.data = data;
            root=nn;
        }else{
            add(root,data);
        }

    }
    private Node add(Node node,int  data){

        if (node == null) {
            Node nn = new Node();
            nn.data = data;
            return nn;
        }

        if(data <= node.data){
            node.left=add(node.left,data);
        }else{
            node.right = add(node.right,data);
        }

        return node;
    }

    //sending parent in argument
    public void add2(int item){
        if(root == null){
            Node nn = new Node();
            nn.data = item;
            root=nn;
        }else{
            add2(root,null,item);
        }

    }
    private void add2(Node node, Node parent, int item){

        if(node == null){
            Node nn = new Node();
            nn.data= item;

            if(item <= parent.data)
                parent.left = nn;
            else
                parent.right = nn;
            return;
        }

        if(item <= node.data)
            add2(node.left, node , item);
        else
            add2(node.right,node,item);
    }




    //way 1:-- making a variable in heap(similar to global variable)
    public void replaceWithSumLarger(){
        replaceWithSumLarger(root, new int[1]);
    }
    private void replaceWithSumLarger(Node node,int[] sum){
        if(node == null)
            return;

        replaceWithSumLarger(node.right,sum);

        int temp = node.data;
        node.data = sum[0];
        sum[0]+=temp;

        replaceWithSumLarger(node.left,sum);
    }

    public void replaceWithSumLarger2(){
        System.out.println(replaceWithSumLarger2(root,0));
    }
    private int replaceWithSumLarger2(Node node,int val){
        if(node == null)
            return val;

        int largeSumVal = replaceWithSumLarger2(node.right,val);
        int temp = node.data;
        node.data = largeSumVal;

        return replaceWithSumLarger2(node.left, largeSumVal+temp);
    }

    public void printInRange(int lo,int hi){
        printInRange(root,lo,hi);
    }
    private void printInRange(Node node,int lo, int hi){
        if(node == null)
            return;

        if(node.data<lo){
            printInRange(node.right,lo,hi);
        }else if( node.data>hi){
            printInRange(node.left,lo,hi);
        }else{
            printInRange(node.left,lo,hi);
            System.out.println(node.data);
            printInRange(node.right,lo,hi);
        }
    }




    public void remove(int item){

        if(root == null)
            return ;

        //cases to handle when only one node is there in tree

        if (root.data == item) {
            if (root.left == null && root.right == null)
                root = null;
            else if (root.left != null && root.right == null)
                root = root.left;
            else if (root.left == null && root.right != null)
                root = root.right;
            else
                remove(root, null, item);
        } else
            remove(root, null, item);


    }
    private void remove(Node node, Node parent, int item){

        if (node == null)
            return;


        if(item < node.data){
            remove(node.left,node,item);
        }else if(item > node.data){
            remove(node.right,node,item);
        }else{

            //case 1: leaf node
            if(node.left == null && node.right==null){
                if(node.data <= parent.data){
                    parent.left=null;
                }else{
                    parent.right=null;
                }

            }

            //case 2: left !=null && right==null
            else if(node.left!=null && node.right==null){

                if(node.data <= parent.data)
                    parent.left=node.left;
                else
                    parent.right=node.left;
            }

            //case 3 : left==nul && right!=null
            else if(node.left==null && node.right!=null){

                if(node.data <= parent.data)
                    parent.left=node.right;
                else
                    parent.right=node.right;
            }

            //case 4: left!=null && right!=null
            else{
                int max = max(node.left);

                remove(node.left,node,max);

                node.data = max;
            }
        }
    }

}
