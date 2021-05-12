package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 304. Range Sum Query 2D - Immutable
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 * <p>
 * Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner
 * (row1, col1) and lower right corner (row2, col2).
 * Implement the NumMatrix class:
 * <p>
 * NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
 * int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix
 * inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input
 * ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
 * [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3],
 * [1, 1, 2, 2], [1, 2, 2, 4]]
 * Output
 * [null, 8, 11, 12]
 * <p>
 * Explanation
 * NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7],
 * [1, 0, 3, 0, 5]]);
 * numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
 * numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
 * numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
 * <p>
 * Constraints:
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * -105 <= matrix[i][j] <= 105
 * 0 <= row1 <= row2 < m
 * 0 <= col1 <= col2 < n
 * At most 104 calls will be made to sumRegion.
 */
public class LeetCode304 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode304()).start();
    }

    @Override
    public void run() {
        //test 1
        of(LeetCodeUtils.buildMatrix("[[8,-4,5],[-1,4,4],[-2,3,1],[-4,4,3]]"));
        System.out.println(sumRegion(0, 1, 0, 2));
        System.out.println(sumRegion(1, 1, 1, 2));
        System.out.println(sumRegion(0, 1, 0, 2));

        //test 2
        of(LeetCodeUtils.buildMatrix("[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]"));
        System.out.println(sumRegion(0, 0, 4, 4));
        System.out.println(sumRegion(0, 0, 1, 1));
        System.out.println(sumRegion(2, 1, 4, 3));
        System.out.println(sumRegion(1, 1, 2, 2));
        System.out.println(sumRegion(1, 2, 2, 4));
    }

    private int[][] sum;

    public void of(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        this.sum = new int[m][n];

        sum[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            sum[0][i] = sum[0][i - 1] + matrix[0][i];
        }
        for (int j = 1; j < m; j++) {
            sum[j][0] = sum[j - 1][0] + matrix[j][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2][col2] - getSum(row1 - 1, col2) - getSum(row2, col1 - 1) + getSum(row1 - 1, col1 - 1);
    }

    private int getSum(int row, int col) {
        if (row < 0 || col < 0) return 0;
        return sum[row][col];
    }
}
