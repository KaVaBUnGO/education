package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1329. Sort the Matrix Diagonally
 * <p>
 * A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column
 * and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting
 * from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].
 * <p>
 * Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.
 */
public class LeetCode1329 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}})));
        System.out.println(Arrays.deepToString(diagonalSort(new int[][]{{3, 3}, {2, 2}, {1, 1}})));
        System.out.println(Arrays.deepToString(diagonalSort(new int[][]{{3}, {2}, {1}})));
        System.out.println(Arrays.deepToString(diagonalSort(new int[][]{{3}})));
    }

    public static int[][] diagonalSort(int[][] mat) {
        int l = mat[0].length;
        int h = mat.length;
        List<List<Integer>> sorted = new ArrayList<>();
        for (int i = 0; i < l + h - 1; i++) {
            sorted.add(new ArrayList<>());
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                sorted.get(h - i + j - 1).add(mat[i][j]);
            }
        }
        sorted.forEach(Collections::sort);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < l; j++) {
                mat[i][j] = sorted.get(j + h - i - 1).get(Math.min(i, j));
            }
        }
        return mat;
    }
}