package GenericTree;

public class Client {

    // 10 3 20 2 50 0 60 0 30 0 40 1 70 0
    // 10 3 20 2 50 0 60 2 100 0 110 2 170 0 180 0 30 2 70 0 80 2 120 0 140 2 190 0 200 0 40 2 90 2 150 0 160 0 100 0
    public static void main(String[] args) {
        GenericTree gt = new GenericTree();
//        gt.display();
//        System.out.println(gt.size());
//        System.out.println(gt.max());
//        System.out.println(gt.find(600));
//        System.out.println(gt.height());
//        gt.mirror();
//        gt.display();
//        gt.printAtLevel(2);
//

//        gt.preorder();
//        gt.postorder();

//        gt.levelOrder();
//        System.out.println();
//        System.out.println("----------------");
//        gt.levelOrderLineWise();
//        System.out.println();
//        System.out.println("----------------");
        gt.levelOrderZigZag();
    }
}
