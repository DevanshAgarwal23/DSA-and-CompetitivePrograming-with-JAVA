package InterviewQuestions.Microsoft;

import java.util.*;


// May 2024 -> This question was asked in Microsoft Codility Online Assessment round
public class MicrosoftCodilityOAGraph {
    public int solution(int N, int[] a, int[] b) {
        int ans = 0;

        // Create a map from integers to a set of integers
        Map<Integer, Set<Integer>> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]); // Max-heap based on the size of the set

        // Building the map with connections from both arrays
        for (int i = 0; i < a.length; i++) {
            map.putIfAbsent(a[i], new HashSet<>());
            map.putIfAbsent(b[i], new HashSet<>());
            map.get(a[i]).add(b[i]);
            map.get(b[i]).add(a[i]);
        }

        // Populating the priority queue with entries from the map
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            pq.add(new int[]{entry.getValue().size(), entry.getKey()});
        }

        // Calculating the result while there are entries in the priority queue
        while (!pq.isEmpty()) {
            int[] node = pq.poll(); // Retrieves and removes the head of this queue
            ans += node[0] * N; // Multiply the size of each set by N
            N--; // Decrement N after each calculation
        }

        return ans;
    }

    public static void main(String[] args) {
        MicrosoftCodilityOAGraph sol = new MicrosoftCodilityOAGraph();
        int[] a = {1, 2, 3, 4};
        int[] b = {2, 3, 4, 5};
        int result = sol.solution(5, a, b);
        System.out.println("Result: " + result);
    }
}