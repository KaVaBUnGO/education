package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 417. Pacific Atlantic Water Flow
 * <p>
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches
 * the right and bottom edges.
 * <p>
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * <p>
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * <p>
 * Note:
 * <p>
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 * <p>
 * Example:
 * <p>
 * Given the following 5x5 matrix:
 * <p>
 * Pacific ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   *   * Atlantic
 * <p>
 * Return:
 * <p>
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
public class LeetCode417 {

    public static void main(String[] args) {
        List<List<Integer>> lists = pacificAtlantic(new int[][]{{19, 16, 16, 12, 14, 0, 17, 11, 2, 0, 18, 9, 13, 16, 8, 8, 8, 13, 17, 9, 16, 9, 4, 7, 1, 19, 10, 7, 0, 15}, {0, 11, 4, 14, 9, 0, 6, 13, 16, 5, 19, 9, 4, 5, 4, 12, 0, 13, 0, 7, 9, 12, 13, 15, 3, 7, 4, 9, 15, 1}, {13, 14, 12, 12, 12, 16, 6, 15, 13, 1, 8, 9, 11, 14, 14, 10, 19, 11, 10, 0, 5, 18, 4, 12, 7, 13, 17, 15, 18, 1}, {16, 14, 19, 5, 8, 2, 11, 17, 7, 1, 4, 6, 5, 18, 7, 15, 6, 19, 18, 12, 1, 14, 2, 2, 0, 9, 15, 14, 13, 19}, {17, 4, 12, 9, 12, 10, 12, 10, 4, 5, 12, 7, 2, 12, 18, 10, 10, 8, 6, 1, 5, 13, 10, 3, 5, 3, 11, 4, 8, 11}, {8, 19, 18, 9, 6, 2, 7, 3, 19, 6, 0, 17, 9, 12, 11, 1, 15, 11, 18, 1, 8, 11, 1, 11, 16, 7, 8, 17, 15, 0}, {7, 0, 5, 11, 1, 7, 12, 18, 12, 1, 5, 2, 11, 7, 18, 12, 0, 11, 9, 18, 5, 2, 3, 1, 1, 1, 8, 14, 19, 5}, {2, 14, 2, 16, 17, 19, 10, 16, 1, 16, 16, 3, 19, 12, 13, 17, 19, 12, 16, 10, 16, 8, 16, 12, 6, 12, 13, 17, 9, 12}, {8, 1, 10, 5, 7, 0, 15, 19, 8, 15, 4, 12, 18, 18, 13, 11, 5, 2, 8, 3, 15, 4, 3, 7, 7, 14, 15, 11, 6, 16}, {0, 5, 13, 19, 1, 1, 2, 4, 16, 2, 16, 9, 15, 15, 10, 10, 18, 11, 17, 1, 5, 14, 5, 19, 7, 0, 13, 7, 13, 7}, {11, 6, 16, 12, 4, 2, 9, 11, 17, 19, 12, 10, 6, 16, 17, 5, 1, 18, 19, 7, 15, 1, 14, 0, 3, 19, 7, 3, 4, 13}, {4, 11, 8, 10, 10, 19, 7, 18, 4, 2, 2, 14, 6, 9, 18, 14, 2, 16, 5, 3, 19, 17, 4, 3, 7, 1, 12, 2, 4, 3}, {14, 16, 3, 11, 13, 13, 6, 16, 18, 0, 17, 19, 4, 1, 14, 12, 4, 17, 5, 19, 8, 13, 15, 3, 15, 4, 1, 14, 12, 10}, {13, 2, 12, 2, 16, 12, 19, 10, 19, 12, 19, 14, 12, 17, 16, 3, 13, 7, 3, 15, 16, 7, 10, 15, 14, 10, 6, 5, 2, 18}});
        //List<List<Integer>> lists = pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}});
        System.out.println(lists);
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Point> stack = new Stack<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                boolean isFirst = false;
                boolean isSecond = false;
                Point current = new Point(i, j);
                stack.add(current);
                boolean[][] used = new boolean[matrix.length][matrix[0].length];
                used[i][j] = true;
                while (!stack.isEmpty()) {
                    Point p = stack.pop();
                    if (p.i == 0 || p.j == 0) {
                        isFirst = true;
                    }
                    if (p.i == matrix.length - 1 || p.j == matrix[p.i].length - 1) {
                        isSecond = true;
                    }
                    if (isFirst && isSecond) {
                        ans.add(List.of(current.i, current.j));
                        break;
                    }

                    if (p.i - 1 >= 0 && !used[p.i - 1][p.j] && matrix[p.i - 1][p.j] <= matrix[p.i][p.j]) {
                        used[p.i - 1][p.j] = true;
                        stack.push(new Point(p.i - 1, p.j));
                    }
                    if (p.i + 1 < matrix.length && !used[p.i + 1][p.j] && matrix[p.i + 1][p.j] <= matrix[p.i][p.j]) {
                        used[p.i + 1][p.j] = true;
                        stack.push(new Point(p.i + 1, p.j));
                    }
                    if (p.j + 1 < matrix[p.i].length && !used[p.i][p.j + 1] && matrix[p.i][p.j + 1] <= matrix[p.i][p.j]) {
                        used[p.i][p.j + 1] = true;
                        stack.push(new Point(p.i, p.j + 1));
                    }
                    if (p.j - 1 >= 0 && !used[p.i][p.j - 1] && matrix[p.i][p.j - 1] <= matrix[p.i][p.j]) {
                        used[p.i][p.j - 1] = true;
                        stack.push(new Point(p.i, p.j - 1));
                    }
                }
                stack.clear();
            }
        }

        return ans;
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