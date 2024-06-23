package MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CustomConcurrentHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private final int capacity;
    private final float loadFactor;
    private List<Node<K, V>>[] buckets;
    private ReentrantLock[] locks;

    public CustomConcurrentHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public CustomConcurrentHashMap(int capacity) {
        this.capacity = capacity;
        this.loadFactor = LOAD_FACTOR;
        this.buckets = new ArrayList[capacity];
        this.locks = new ReentrantLock[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new ArrayList<>();
            locks[i] = new ReentrantLock();
        }
    }

    public void put(K key, V value) {
        int hash = hash(key);
        int bucketIndex = getBucketIndex(hash);

        locks[bucketIndex].lock();
        try {
            List<Node<K, V>> bucket = buckets[bucketIndex];
            for (Node<K, V> node : bucket) {
                if (node.key.equals(key)) {
                    node.value = value;
                    return;
                }
            }
            bucket.add(new Node<>(key, value));
        } finally {
            locks[bucketIndex].unlock();
        }
    }

    public V get(K key) {
        int hash = hash(key);
        int bucketIndex = getBucketIndex(hash);

        locks[bucketIndex].lock();
        try {
            List<Node<K, V>> bucket = buckets[bucketIndex];
            for (Node<K, V> node : bucket) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
            return null;
        } finally {
            locks[bucketIndex].unlock();
        }
    }

    public void remove(K key) {
        int hash = hash(key);
        int bucketIndex = getBucketIndex(hash);

        locks[bucketIndex].lock();
        try {
            List<Node<K, V>> bucket = buckets[bucketIndex];
            bucket.removeIf(node -> node.key.equals(key));
        } finally {
            locks[bucketIndex].unlock();
        }
    }

    public List<K> keySet() {
        List<K> keys = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            locks[i].lock();
            try {
                for (Node<K, V> node : buckets[i]) {
                    keys.add(node.key);
                }
            } finally {
                locks[i].unlock();
            }
        }
        return keys;
    }

    private int hash(K key) {
        return key.hashCode();
    }

    private int getBucketIndex(int hash) {
        return Math.abs(hash % capacity);
    }

    private static class Node<K, V> {
        private final K key;
        private V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        CustomConcurrentHashMap<String, Integer> map = new CustomConcurrentHashMap<>();

        // ExecutorService to manage threads
        ExecutorService executorService = Executors.newFixedThreadPool(10); // 10 threads

        // Submit tasks for put, get, and remove operations
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                String key = "key" + taskId;
                int value = taskId;

                map.put(key, value); // put operation

                System.out.println(Thread.currentThread().getName() + " - Put: " + key + ", " + value);

                Integer retrievedValue = map.get(key); // get operation

                System.out.println(Thread.currentThread().getName() + " - Get: " + key + " -> " + retrievedValue);

                map.remove(key); // remove operation

                System.out.println(Thread.currentThread().getName() + " - Remove: " + key);
            });
        }

        // Shutdown executor service
        executorService.shutdown();
        try {
            executorService.awaitTermination(30, TimeUnit.SECONDS); // wait for threads to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // After all operations, print the final state of the map
        System.out.println("Final state of the map:");
        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}