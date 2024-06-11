package DisjointSet;

import java.util.Arrays;

public class EveryOneBecomeFriends {

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (log1, log2) -> Integer.compare(log1[0], log2[0]));
        DisjointSet ds = new DisjointSet(n);

        for (int[] log : logs) {
            int a = log[1];
            int b = log[2];

            if (ds.findUParent(a) != ds.findUParent(b)) {
                ds.unionByRank(a, b);
                n--;
            }

            if (n == 1)
                return log[0];
        }

        return -1;
    }
}
