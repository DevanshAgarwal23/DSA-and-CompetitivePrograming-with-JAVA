package DesignDSA;

import java.util.*;
class LFUCache {

    private final Map<Integer, Integer> keyToFreq;
    private final TreeMap<Integer, LinkedHashSet<Integer>> freqToKey;
    private final Map<Integer, Integer> keyToValue;
    private final int capacity;

    public LFUCache(int capacity) {
        keyToFreq = new HashMap<>();
        freqToKey = new TreeMap<>();
        keyToValue = new HashMap<>();

        this.capacity = capacity;
    }

    public int get(int key) {
        if (keyToValue.containsKey(key)) {
            increaseFrequency(key);
            return keyToValue.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (keyToFreq.size() == capacity && !keyToValue.containsKey(key))
            removeLastFrequentlyUsed();

        keyToValue.put(key, value);

        if (keyToFreq.containsKey(key))
            increaseFrequency(key);
        else {
            keyToFreq.put(key, 1);
            freqToKey.computeIfAbsent(1, p -> new LinkedHashSet<>()).add(key);
        }
    }

    private void increaseFrequency(int key) {
        int frequency = keyToFreq.get(key);

        keyToFreq.put(key, frequency + 1);
        deletePreviousFrequency(key, frequency);

        freqToKey.computeIfAbsent(frequency + 1, p -> new LinkedHashSet<>()).add(key);
    }

    private void deletePreviousFrequency(int key, int frequency) {
        LinkedHashSet<Integer> keys = freqToKey.get(frequency);
        keys.remove(key);

        if (keys.isEmpty())
            freqToKey.remove(frequency);
    }

    private void removeLastFrequentlyUsed() {
        Map.Entry<Integer, LinkedHashSet<Integer>> first = freqToKey.firstEntry();
        LinkedHashSet<Integer> keys = first.getValue();

        int key = keys.iterator().next();

        keys.remove(key);
        if (keys.isEmpty())
            freqToKey.remove(first.getKey());

        keyToFreq.remove(key);
        keyToValue.remove(key);

    }
}