package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

class StreamDataStructure {
    private Node head, tail;
    private PriorityQueue<Node> minHeap;
    private PriorityQueue<Node> maxHeap;

    public StreamDataStructure() {
        head = tail = null;
        minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.data)); // Default comparator for min heap
        maxHeap = new PriorityQueue<>(Comparator.comparingInt(node -> -node.data)); // Negate data for max heap
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        minHeap.add(newNode);
        maxHeap.add(newNode);
    }

    public void delete(Node nodeToDelete) {
        if (nodeToDelete.prev!= null) nodeToDelete.prev.next = nodeToDelete.next;
        if (nodeToDelete.next!= null) nodeToDelete.next.prev = nodeToDelete.prev;
        if (nodeToDelete == head) head = nodeToDelete.next;
        if (nodeToDelete == tail) tail = nodeToDelete.prev;
        minHeap.remove(nodeToDelete);
        maxHeap.remove(nodeToDelete);
    }

    public int findMin() {
        return minHeap.peek().data;
    }

    public int findMax() {
        return maxHeap.peek().data;
    }
}
