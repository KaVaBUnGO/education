package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 */
public final class LeetCodeUtils {
    /* Build matrix from String input, like as [[x, x, x], [x, x,x], [x, x, x]] */
    public static int[][] buildMatrix(String s) {
        s = s.substring(2, s.length() - 2);
        String[] rows = s.split("],\\[");
        int[][] res = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] numbers = rows[i].split(",");
            int[] row = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                row[j] = Integer.parseInt(numbers[j]);
            }
            res[i] = row;
        }
        return res;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

}
