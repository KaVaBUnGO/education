package com.arturchernov.algo.practice.leetcode;

import static com.arturchernov.algo.practice.leetcode.LeetCodeUtils.buildMatrix;
import static com.arturchernov.algo.practice.leetcode.LeetCodeUtils.printMatrix;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 48. Rotate Image
 * <p>
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 * DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 * <p>
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * Example 3:
 * <p>
 * Input: matrix = [[1]]
 * Output: [[1]]
 * Example 4:
 * <p>
 * Input: matrix = [[1,2],[3,4]]
 * Output: [[3,1],[4,2]]
 * <p>
 * Constraints:
 * <p>
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class LeetCode48 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode48()).run();
    }

    @Override
    public void run() {
        runEx("[[1,2,3],[4,5,6],[7,8,9]]");
        runEx("[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]");
        runEx("[[1]]");
        runEx("[[1,2],[3,4]]");
    }

    private void runEx(String s) {
        int[][] ex1 = buildMatrix(s);
        rotate(ex1);
        printMatrix(ex1);
        System.out.println();
    }

    public void rotate(int[][] a) {
        int n = a.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - i; j++) {
                int k = a[i][j];
                a[i][j] = a[n - j][i];
                a[n - j][i] = a[n - i][n - j];
                a[n - i][n - j] = a[j][n - i];
                a[j][n - i] = k;
            }
        }
    }
}
