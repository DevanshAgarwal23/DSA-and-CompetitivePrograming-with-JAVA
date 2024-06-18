package DesignDSA;

public class HitCounter {
    int[] counts;
    int prev;

    /** Initialize your data structure here. */
    public HitCounter() {
        counts = new int[300];
        prev = 1;
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if (timestamp != prev) {
            clean(timestamp);
            counts[(timestamp - 1) % 300] = 0;
        }
        counts[(timestamp - 1) % 300]++;
        prev = timestamp;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        clean(timestamp);
        if (timestamp > prev) {
            counts[(timestamp - 1) % 300] = 0;
        }
        int sum = 0;
        for (int i : counts)
            sum += i;
        prev = timestamp;
        return sum;
    }

    public void clean(int timestamp) {
        int distance = timestamp - prev > 300 ? 300 : (timestamp - prev) % 300 - 1;
        if (timestamp - prev > 0)
            for (int i = 1; i <= distance; i++)
                counts[(prev - 1 + i) % 300] = 0;
    }
}