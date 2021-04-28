package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 63. Unique Paths II
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Example 1:
 * <p>
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * Example 2:
 * <p>
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 */
public class LeetCode63 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode63()).run();
    }

    @Override
    public void run() {
        System.out.println(uniquePathsWithObstacles(LeetCodeUtils.buildMatrix("[[0,0,0],[0,1,0],[0,0,0]]")));
        System.out.println(uniquePathsWithObstacles(LeetCodeUtils.buildMatrix("[[0,1],[0,0]]")));
    }

    public int uniquePathsWithObstacles(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = (a[m - 1][n - 1] + 1) % 2;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (a[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i][j]
                        + (i + 1 < m ? dp[i + 1][j] : 0)
                        + (j + 1 < n ? dp[i][j + 1] : 0);
            }
        }
        return dp[0][0];
    }
}
