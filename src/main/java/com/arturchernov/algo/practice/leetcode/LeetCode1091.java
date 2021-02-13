package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1091. Shortest Path in Binary Matrix
 * <p>
 * In an N by N square grid, each cell is either empty (0) or blocked (1).
 * <p>
 * A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:
 * <p>
 * Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
 * C_1 is at location (0, 0) (ie. has value grid[0][0])
 * C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
 * If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
 * Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.
 */
public class LeetCode1091 {

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 0, 0, 0, 0}, {1, 1, 1, 1, 0}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}}));
        System.out.println(shortestPathBinaryMatrix(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}, {0, 0, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 0}}));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        ArrayList<Point> v = new ArrayList<>();
        v.add(new Point(0, 1));
        v.add(new Point(1, 0));
        v.add(new Point(1, 1));

        v.add(new Point(0, -1));
        v.add(new Point(-1, 0));
        v.add(new Point(-1, -1));
        v.add(new Point(-1, 1));
        v.add(new Point(1, -1));
        if (grid[0][0] == 1) {
            return -1;
        }
        int[][] dp = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], 10001);
        }
        boolean[][] used = new boolean[grid.length][grid.length];
        Queue<Point> st = new LinkedList<>();
        st.add(new Point(0, 0));
        used[0][0] = true;
        dp[0][0] = 1;
        int it = 0;
        while (!st.isEmpty()) {
            Point current = st.poll();
            for (Point vec : v) {
                if (current.j + vec.j < grid.length && current.j + vec.j >= 0 &&
                        current.i + vec.i < grid.length && current.i + vec.i >= 0 &&
                        !used[current.i + vec.i][current.j + vec.j] && grid[current.i + vec.i][current.j + vec.j] == 0) {
                    st.add(new Point(current.i + vec.i, current.j + vec.j));
                    used[current.i + vec.i][current.j + vec.j] = true;
                    dp[current.i + vec.i][current.j + vec.j] = Math.min(dp[current.i][current.j] + 1, dp[current.i + vec.i][current.j + vec.j]);
                }
            }

        }
        return dp[grid.length - 1][grid.length - 1] == 10001 ? -1 : dp[grid.length - 1][grid.length - 1];
    }

    private static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
