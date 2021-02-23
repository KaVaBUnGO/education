package com.arturchernov.algo.practice.leetcode;

import java.util.Stack;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 240. Search a 2D Matrix II
 * <p>
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix.
 * The matrix has the following properties:
 * <p>
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */
public class LeetCode240 {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1}, {2}, {3}, {4}, {5}}, 4));
        System.out.println(searchMatrix(new int[][]{{1, 4}, {2, 5}}, 1));
        System.out.println(searchMatrix(new int[][]{{1, 2, 3, 4, 5}}, 4));
        System.out.println(searchMatrix(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}, 15));
        System.out.println(searchMatrix(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}, {10, 13, 14}, {18, 21, 23}}, 21));
        System.out.println(searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, -1));
        System.out.println(searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
        System.out.println(searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
        System.out.println(searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 40));
        System.out.println(searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}}, 16));
        System.out.println(searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}}, 22));
        System.out.println(searchMatrix(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9,}, {10, 13, 14}, {18, 21, 23}}, 22));
        System.out.println(searchMatrix(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9,}, {10, 13, 14}, {18, 21, 23}}, 23));
        System.out.println(searchMatrix(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9,}, {10, 13, 14}, {18, 21, 23}}, 24));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int w = matrix[0].length, h = matrix.length;
        Stack<Point> st = new Stack<>();
        st.push(new Point(0, 0, 0));

        while (!st.isEmpty()) {
            Point cur = st.pop();
            if (matrix[cur.i][cur.j] == target) {
                return true;
            }
            if (cur.type == 0) {
                if (cur.i + 1 < h && cur.j + 1 < w && matrix[cur.i + 1][cur.j + 1] <= target) {
                    st.push(new Point(cur.i + 1, cur.j + 1, 0));
                } else {
                    if (cur.i + 1 < h) {
                        st.push(new Point(cur.i + 1, cur.j, 2));
                    }
                    if (cur.j + 1 < w) {
                        st.push(new Point(cur.i, cur.j + 1, 1));
                    }
                }
            } else if (cur.type == 1) {
                if (cur.i - 1 >= 0 && matrix[cur.i - 1][cur.j] >= target) {
                    st.push(new Point(cur.i - 1, cur.j, 1));
                } else if (cur.j + 1 < w) {
                    st.push(new Point(cur.i, cur.j + 1, 1));
                }
            } else if (cur.type == 2) {
                if (cur.j - 1 >= 0 && matrix[cur.i][cur.j - 1] >= target) {
                    st.push(new Point(cur.i, cur.j - 1, 2));
                } else if (cur.i + 1 < h) {
                    st.push(new Point(cur.i + 1, cur.j, 2));
                }
            }
        }
        return false;
    }

    private static class Point {
        int i;
        int j;
        int type = 0;

        public Point(int i, int j, int type) {
            this.i = i;
            this.j = j;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "i=" + i +
                    ", j=" + j +
                    ", type=" + type +
                    '}';
        }
    }
}