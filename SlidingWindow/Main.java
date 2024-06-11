//package SlidingWindow;
//
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt(); // Number of points following the initial two special points
//        long[][] points = new long[n + 2][2]; // Array to hold the coordinates of points including two special points
//
//        // Reading the coordinates for all points including two special points
//        for (int i = 0; i < n + 2; i++) {
//            points[i][0] = in.nextInt(); // X-coordinate
//            points[i][1] = in.nextInt(); // Y-coordinate
//        }
//
//        // DP array to memoize the results of recursive calls
//        long[][] dp = new long[n + 2][n + 2];
//        for (long[] row : dp) Arrays.fill(row, -1); // Initialize with -1
//
//        // Calculate the total distance from each starting point
//        long dist1 = Math.abs(points[0][0] - points[2][0]) + Math.abs(points[0][1] - points[2][1]) + solve(points, dp, 2, 1);
//        long dist2 = Math.abs(points[1][0] - points[2][0]) + Math.abs(points[1][1] - points[2][1]) + solve(points, dp, 0, 2);
//
//        // Output the minimum of the two computed distances
//        System.out.println(Math.min(dist1, dist2));
//    }
//
//    // Recursive method to compute the minimum distance
//    public static long solve(long[][] points, long[][] dp, int p1, int p2) {
//        int nextIndex = Math.max(p1, p2) + 1; // Determine the next point to consider
//        if (nextIndex >= points.length) return 0; // Base case: if no more points, return 0
//
//        if (dp[p1][p2] != -1) return dp[p1][p2]; // Return memoized result if available
//
//        // Recurse: choose the next point for each path and calculate distances
//        long distNextP1 = Math.abs(points[p1][0] - points[nextIndex][0]) + Math.abs(points[p1][1] - points[nextIndex][1]) + solve(points, dp, nextIndex, p2);
//        long distNextP2 = Math.abs(points[p2][0] - points[nextIndex][0]) + Math.abs(points[p2][1] - points[nextIndex][1]) + solve(points, dp, p1, nextIndex);
//
//        // Store and return the minimum of the two computed distances
//        return dp[p1][p2] = Math.min(distNextP1, distNextP2);
//    }
//
//
//    int computeMinDist(int N, int xi, int yi, int xj, int yj, int apples[][], int idx) {
//
//
//        if ( idx >= N) { return 0;}
//
//        int nextX = apples[idx][0], nextY = apples[idx][1];
//
//        int ansi =  abs(xi - nextX) + abs(yi - nextY) + computeMinDist(N, nextX, nextY, xj, yj, apples, idx + 1);
//        int ansj =  abs(xj - nextX) + abs(yj- nextY)  + computeMinDist(N, xi, yi, nextX, nextY, apples, idx + 1);
//
//        return min(ansi, ansj);
//    }
//    int appleDistances(int N, int xi, int yi, int xj, int yj, int apples[][2]) {
//        return computeMinDist(N, xi, yi, xj, yj, apples, 0);
//    }
//}