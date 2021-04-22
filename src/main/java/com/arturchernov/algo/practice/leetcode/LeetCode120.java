package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 120. Triangle
 * <p>
 * Given a triangle array, return the minimum path sum from top to bottom.
 * <p>
 * For each step, you may move to an adjacent number of the row below. More formally,
 * if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 * <p>
 * Example 1:
 * <p>
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * Output: 11
 * Explanation: The triangle looks like:
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
 * Example 2:
 * <p>
 * Input: triangle = [[-10]]
 * Output: -10
 * <p>
 * Constraints:
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * <p>
 * Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
 */
public class LeetCode120 {

    private static int globalSum = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] ints = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};

        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            triangle.add(new ArrayList<>());
            for (int j = 0; j < ints[i].length; j++) {
                triangle.get(i).add(ints[i][j]);
            }
        }
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() > 1) {
            for (int row = triangle.size() - 2; row >= 0; row--) {
                for (int col = 0; col < triangle.get(row).size(); col++) {
                    triangle.get(row).set(col, Math.min(
                            triangle.get(row).get(col) + triangle.get(row + 1).get(col),
                            triangle.get(row).get(col) + triangle.get(row + 1).get(col + 1)
                    ));
                }
            }
        }
        return triangle.get(0).get(0);
    }
}