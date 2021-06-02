package com.arturchernov.algo.practice.leetcode;

import java.util.Stack;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 695. Max Area of Island
 * <p>
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
 * (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * <p>
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 * <p>
 * Constraints:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */
public class LeetCode695 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode695()).start();
    }

    @Override
    public void run() {
        System.out.println(maxAreaOfIsland(LeetCodeUtils.buildMatrix("[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]")));
        System.out.println(maxAreaOfIsland(LeetCodeUtils.buildMatrix("[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]")));
        System.out.println(maxAreaOfIsland(LeetCodeUtils.buildMatrix("[[0,0,0,0,0,0,0,0]]")));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!used[i][j] && grid[i][j] == 1) {
                    ans = Math.max(ans, search(i, j, grid, used));
                }
            }
        }
        return ans;
    }

    private int search(int i, int j, int[][] grid, boolean[][] used) {
        int ans = 0;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(i, j));
        used[i][j] = true;
        while (!st.isEmpty()) {
            Pair cur = st.pop();
            ++ans;
            if (cur.i - 1 >= 0 && !used[cur.i - 1][cur.j] && grid[cur.i - 1][cur.j] == 1) {
                st.add(new Pair(cur.i - 1, cur.j));
                used[cur.i - 1][cur.j] = true;
            }
            if (cur.i + 1 < grid.length && !used[cur.i + 1][cur.j] && grid[cur.i + 1][cur.j] == 1) {
                st.add(new Pair(cur.i + 1, cur.j));
                used[cur.i + 1][cur.j] = true;
            }
            if (cur.j - 1 >= 0 && !used[cur.i][cur.j - 1] && grid[cur.i][cur.j - 1] == 1) {
                st.add(new Pair(cur.i, cur.j - 1));
                used[cur.i][cur.j - 1] = true;
            }
            if (cur.j + 1 < grid[0].length && !used[cur.i][cur.j + 1] && grid[cur.i][cur.j + 1] == 1) {
                st.add(new Pair(cur.i, cur.j + 1));
                used[cur.i][cur.j + 1] = true;
            }
        }
        return ans;
    }

    private static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
