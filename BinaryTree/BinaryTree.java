package BinaryTree;

import java.util.*;

public class BinaryTree {

    Scanner sc = new Scanner(System.in);
    private class Node{
        int data;
        Node left;
        Node right;
    }

    private Node root;

    public BinaryTree(){
       root = construct(null,true);
    }

    // ilc:- isLeftChild
    // ilc: true --> create parent left child
    // ilc: false --> create parent right child
    private Node construct(Node parent, boolean ilc){

        if(parent == null)
            System.out.println("Enter the data for root node");
        else{

            if(ilc)
                System.out.println("Enter the data for left child of "+ parent.data +" ?");
            else
                System.out.println("Enter the data for right child of "+ parent.data +" ?");
        }
        int item = sc.nextInt();

        Node nn = new Node();
        nn.data = item;

        System.out.println(nn.data + " has left child ?");
        boolean hlc = sc.nextBoolean(); //hlc:- hasLeftChild

        if(hlc)
            nn.left = construct(nn,true);


        System.out.println(nn.data + " has right child ?");
        boolean hrc = sc.nextBoolean(); //hrc:- hasRightChild

        if(hrc)
            nn.right = construct(nn,false);



        return  nn;
    }



    // construct binary tree using preorder and inorder
    public BinaryTree(int[] pre,int[] in){
        root= construct(pre,0,pre.length,in,0,in.length);
    }
    private Node construct (int[] pre,int plo,int phi,int[] in,int ilo,int ihi){

        if(plo>phi || ilo>ihi)
            return null;

        Node nn = new Node();
        nn.data = pre[plo];

        int si =-1;
        int nel = 0;//no of element
        for(int i=ilo;i<-ihi;i++){
            if(in[i] == pre[plo]){
                si =i;
                break;
            }
            nel++;
        }

        nn.left = construct(pre,plo+1,plo+nel,in,ilo,si-1);
        nn.right = construct(pre,plo+nel+1,phi,in,si+1,ihi);

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

    public boolean find(int item){
        return find(root,item);
    }
    private boolean find(Node node,int item){
        if(node == null)
            return false;

        if(node.data==item)
            return true;

        boolean lr = find(node.left,item);
        if(lr)
            return true;

        boolean rr = find(node.right,item);
        if(rr)
            return true;


        return false;

    }

    public int max(){
        return max(root);
    }
    private int max(Node node){

        if(node == null)
            return Integer.MIN_VALUE;

        int totalMax = node.data;
        int lr = max(node.left);
        totalMax=Math.max(totalMax,lr);
        int rr = max(node.right);
        totalMax=Math.max(totalMax,rr);

        return totalMax;
    }

    public int height(){
        return height(root);
    }
    private int height(Node node){

        if(node == null)
            return -1;

        int lr=height(node.left);
        int rr=height(node.right);

        return Math.max(lr,rr)+1;
    }

    //Most important

    int max = Integer.MIN_VALUE;

    public int diameter(){
        diameter(root);
        return max;
    }
    private void diameter(Node node){
        if(node==null){
            return;

        }

        diameter(node.left);
        diameter(node.right);

        int diameterRootNode = height(node.left)+height(node.right)+2;

        max = Math.max(max,diameterRootNode);

    }

    public int diameter1(){
        return diameter1(root);
    }
    private int diameter1(Node node){
        if(node == null)
            return 0;

        //max distance between two nodes on left side
        int ld= diameter1(node.left);
        //max distance between two nodes on right side
        int rd= diameter1(node.right);

        //max distance between left's deepest and right's deepest
        int factor = height(node.left)+height(node.right)+2;

        return Math.max(factor,Math.max(ld,rd));
    }


    // Time Complexity = O(N), above 2 methods where O(n^2)
   static class DiaPair{
        int ht;
        int dia;
   }
    public int diameter2(){
        DiaPair result =diameter2(root);
        return result.dia;
    }
    private DiaPair diameter2(Node node){
        if(node ==null){
            DiaPair bp = new DiaPair();
            bp.ht=-1;
            bp.dia=0;
            return bp;
        }

        DiaPair lp = diameter2(node.left);
        DiaPair rp = diameter2(node.right);

        DiaPair mp = new DiaPair();
        mp.ht = Math.max(lp.ht,rp.ht)+1;

        int factor = lp.ht + rp.ht+2;
        mp.dia=Math.max(factor,Math.max(lp.dia,rp.dia));

        return mp;
    }



    boolean balance = true;
    public boolean isBalanced(){
        isBalanced(root);
        return balance;
    }
    private void isBalanced(Node node){
        if(node == null)
            return;

        isBalanced(node.left);
        isBalanced(node.right);

        int res = height(node.left)-height(node.right);
        boolean check;
        if(res==0 || res==1 || res== -1 )
            check=true;
        else
            check=false;

        balance = balance && check;
    }

    public boolean isBalance2(){
        return  isBalanced2(root);
    }
    private boolean isBalanced2(Node node){

        if(node == null)
            return true;

        boolean lb = isBalanced2(node.left);
        boolean rb = isBalanced2(node.right);

        int bf = height(node.left)-height(node.right);

        if(lb && rb && (bf == 0 || bf == 1 || bf == -1))
            return true;
        else
            return false;
    }

    static class BalPair{
        int ht;
        boolean balance;
    }
    public boolean isBalance3(){
        BalPair res = isBalance3(root);
        return res.balance;
    }
    private  BalPair isBalance3(Node node){
        if(node == null){
            BalPair bp = new BalPair();
            bp.ht=-1;
            bp.balance = true;
        }

        BalPair lbp = isBalance3(node.left);
        BalPair rbp = isBalance3(node.right);

        BalPair sbp = new BalPair();

        int bf = lbp.ht- rbp.ht;
        boolean lb = lbp.balance;
        boolean rb = rbp.balance;

        if(lb && rb && (bf ==1 || bf==0 || bf==-1))
            sbp.balance=true;
        else
            sbp.balance=false;

        sbp.ht = Math.max(lbp.ht, rbp.ht)+1;

        return sbp;
    }

    public boolean flipEquivalent(BinaryTree other){
        return flipEquivalent(this.root,other.root);
    }

    private boolean flipEquivalent(Node n1, Node n2){
        if(n1 ==null && n2 ==null)
            return true;

        if(n1 ==null || n2==null)
            return false;


        if(n1.data != n2.data)
            return false;

        boolean flip = flipEquivalent(n1.left, n2.right) && flipEquivalent(n1.right,n2.left);

        boolean noFlip = flipEquivalent(n1.left,n2.left) && flipEquivalent(n1.right,n2.right);

        return  flip || noFlip;
    }

    // Traversals
    public void preorder() {
        preorder(root);
        System.out.println();
    }

    // NLR : preorder
    // LNR : inorder
    // LRN : postorder
    // NRL : rev postorder
    // RNL : rev inorder
    // RLN : rev preorder
    private void preorder(Node node) {

        if (node == null)
            return;

        // N
        System.out.print(node.data + " ");

        // L
        preorder(node.left);

        // R
        preorder(node.right);

    }

    //iterative

    private class Pair {
        Node n;
        boolean sd; //self done
        boolean ld; //left done
        boolean rd; //right done
    }

    public void preorderI(){
        Stack<Pair> s = new Stack<>();

        Pair sp = new Pair();//start pair
        sp.n = root;

        s.push(sp);

        while(!s.isEmpty()) {

           Pair tp = s.peek();

           if(!tp.sd){
               System.out.println(tp.n.data);
               tp.sd = true;

           }else if(!tp.ld){
               Pair lp = new Pair();
               lp.n = tp.n.left;
               s.push(lp);
               tp.ld = true;
           }else if(!tp.rd){
               Pair rp = new Pair();
               rp.n = tp.n.right;

               s.push(rp);

               tp.rd=true;
           }else {
               s.pop();
           }
        }
        System.out.println();
    }


    // LevelOrder Traversal
    public void levelOrder(){
        levelOrder(root);
    }
    private void levelOrder(Node node){
        Queue<Node> mq = new LinkedList<>();
        mq.add(node);

        while(mq.size()>0){
            int count = mq.size();
            for(int i=0;i<count;i++){
                node = mq.remove();
                System.out.println(node.data+" ");

                if(node.left!=null)
                    mq.add(node.left);

                if(node.right != null)
                    mq.add(node.right);
            }
            System.out.println();
        }


    }


    // Maximum Subtree Sum


    public int sum(){
       return sum(root);
    }
    private int sum(Node node){
        if(node==null)
            return 0;

        int ls = sum(node.left);
        int rs = sum(node.right);

        return ls+rs+node.data;
    }

    //way 1
    private Integer maxSum = Integer.MIN_VALUE;
    public int maxSubtreeSum1(){
        int maxRoot = maxSubtreeSum1(root);
        return maxSum;
    }

    private int maxSubtreeSum1(Node node){
        if(node == null)
            return 0;

        int leftSum = maxSubtreeSum1(node.left);
        int rightSum = maxSubtreeSum1(node.right);

        int totalSum = leftSum+rightSum+node.data;

        maxSum = Math.max(maxSum,totalSum);

        return totalSum;
    }

    // ** way 1:---> alternate (making a variable in heap without declaring variable globally)
    public int maxSubtreeSum(){
        int[] maxSum = new int[1];
        int maxRoot = maxSubtreeSum(root,maxSum);
        return maxSum[0];
    }
    private int maxSubtreeSum(Node node,int[] maxSum){
        if(node == null)
            return 0;

        int leftSum = maxSubtreeSum(node.left,maxSum);
        int rightSum = maxSubtreeSum(node.right,maxSum);

        int totalSum = leftSum+rightSum+node.data;

        maxSum[0] = Math.max(maxSum[0],totalSum);

        return totalSum;
    }



    //way 2
    public int maxSubtreeSum2(){
        return maxSubtreeSum2(root);
    }
    private int maxSubtreeSum2(Node node){
        if(node == null)
            return 0;

        int leftMaxSum = maxSubtreeSum2(node.left);
        int rightMAxSum = maxSubtreeSum2(node.right);

        int selfSum = sum(node.left)+sum(node.right)+node.data;

        return Math.max(selfSum,Math.max(leftMaxSum,rightMAxSum));
    }

    // way 3

    //MSS : max subtree sum
    private static class MSSPair {
        int mss = Integer.MIN_VALUE;//maxsubtreesum
        int totalSum = 0;
    }
    public int maxSubtreeSum3(){
        return maxSubtreeSum3(root).mss;
    }
    private MSSPair maxSubtreeSum3(Node node){
        if(node == null)
            return new MSSPair();

        MSSPair lp = maxSubtreeSum3(node.left);
        MSSPair rp = maxSubtreeSum3(node.right);

        MSSPair sp = new MSSPair();

        //sp maxSubtreeSum
        sp.mss = Math.max(lp.totalSum+rp.totalSum+node.data,Math.max(lp.mss,rp.mss));

        //sp totalSum
        sp.totalSum=lp.totalSum+rp.totalSum+node.data;

        return sp;
    }




    // Vertical Order Traversal (Used for bottom view and top view of Binary Tree)

    private class VOPair {

        Node node;
        int vl;

        public VOPair(Node node, int vl) {
            this.node = node;
            this.vl = vl;
        }

        @Override
        public String toString() {
            return node.data + " -> " + vl;
        }
    }

    public void verticalOrderTraversal() {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        Queue<VOPair> q = new LinkedList<>();

        VOPair sp = new VOPair(root, 0);
        q.add(sp);

        while (!q.isEmpty()) {

            VOPair rp = q.remove();

            if (!map.containsKey(rp.vl))
                map.put(rp.vl, new ArrayList<>());

            map.get(rp.vl).add(rp.node.data);

            if (rp.node.left != null) {

                VOPair lcp = new VOPair(rp.node.left, rp.vl - 1);
                q.add(lcp);

            }

            if (rp.node.right != null) {

                VOPair rcp = new VOPair(rp.node.right, rp.vl + 1);
                q.add(rcp);

            }

        }

        ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
        Collections.sort(keys);

        for (int key : keys)
            System.out.println(key + " -> " + map.get(key));

    }

}