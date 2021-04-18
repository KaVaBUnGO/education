package com.arturchernov.algo.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1074. Number of Submatrices That Sum to Target
 * <p>
 * Given a matrix and a target, return the number of non-empty submatrices that sum to target.
 * <p>
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
 * <p>
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different
 * if they have some coordinate that is different: for example, if x1 != x1'.
 */
public class LeetCode1074 {

    public static void main(String[] args) {
        System.out.println(numSubmatrixSumTarget(new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}}, 0));
    }

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int countOfRows = matrix.length;
        int countOfColumns = matrix[0].length + 1;
        int[][] prefixSum = new int[countOfRows][countOfColumns];

        for (int i = 0; i < countOfRows; i++) {
            for (int j = 1; j < countOfColumns; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j - 1];
            }
        }

        for (int start = 0; start < countOfColumns; start++) {
            for (int end = start + 1; end < countOfColumns; end++) {
                int sumOfSubMatrix = 0;
                Map<Integer, Integer> hm = new HashMap<>();
                hm.put(0, 1);
                for (int k = 0; k < countOfRows; k++) {
                    sumOfSubMatrix += prefixSum[k][end] - prefixSum[k][start];
                    if (hm.containsKey(sumOfSubMatrix - target)) {
                        ans += hm.get(sumOfSubMatrix - target);
                    }
                    hm.put(sumOfSubMatrix, hm.getOrDefault(sumOfSubMatrix, 0) + 1);
                }
            }
        }
        return ans;
    }
}