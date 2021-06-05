package BinaryTree;

public class Client {
    public static void main(String[] args) {
        // 10 true  20 true 40 false false true 50 false false true 30 false true 70 false false
        BinaryTree bt = new BinaryTree();
        bt.display();
//        System.out.println(bt.find((40)));
//        System.out.println(bt.find(80));

        System.out.println(bt.isBalanced());
        System.out.println(bt.maxSubtreeSum1());
        System.out.println(bt.maxSubtreeSum2());


    }
}

 //10 true 20 true 40 true 2 false false true 3 false false true -60 false false true -30 true 50 true 60 true 80 false false false true 70 false false true -100 false false
