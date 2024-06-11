package XProblemSolving;
import java.util.*;
import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {
        int [] arr= {17, 12, 10, 2, 7, 2, 11, 20, 8};
        System.out.println(teamFormation(arr, 3, 4));
    }

    public static int teamFormation(int[] nums, int size, int m) {
        int res = 0;
        Node head = new Node(-1);
        Node tail = new Node(-1);
        Node headRef = head;
        Node tailRef = tail;
        for(int i=0;i<nums.length;i++) {
            Node node = new Node(nums[i]);
            node.left = headRef;
            headRef.right = node;
            headRef = headRef.right;
        }
        headRef.right = tailRef;
        tailRef.left = headRef;
        for(int i=0;i<size;i++) {
            Node max = head;
            Node start = head.right;
            Node end = tail.left;
            for(int j=0;j<m;j++) {
                if(end != null) {
                    if(end.val > max.val)
                        max = end;
                    end = end.left;
                }
                if(start != null) {
                    if(start.val > max.val)
                        max = start;
                    start = start.right;
                }
            }
            if(max.left != null && max.right != null) {
                max.left.right = max.right;
                max.right.left = max.left;
                res += max.val;
            }
        }
        return res;
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            super();
            this.val = val;
        }
    }

}
