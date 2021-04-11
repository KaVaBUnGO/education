package com.arturchernov.algo.practice.leetcode;

import java.util.*;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 329. Longest Increasing Path in a Matrix
 * <p>
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 * <p>
 * From each cell, you can either move in four directions: left, right, up, or down.
 * You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 */
public class LeetCode329 {

    public static void main(String[] args) {
        System.out.println(longestIncreasingPath(new int[][]{{1}}));
        System.out.println(longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
        System.out.println(longestIncreasingPath(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}));
    }

    private static Map<Integer, List<Integer>> g = new HashMap<>();
    private static Map<Integer, List<Integer>> ig = new HashMap<>();
    private static int global = 0;
    private static Map<Integer, Integer> vMapping = new HashMap<>();
    private static int local = 0;

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 1 && matrix[0].length == 1) {
            return 1;
        }
        buildGraph(matrix);
        ArrayList<Integer> sorted = new ArrayList<>();
        topSort(sorted);
        return searchInSorted(sorted);
    }

    private static int searchInSorted(ArrayList<Integer> sorted) {
        int[] max = new int[local];
        Stack<Integer> st = new Stack<>();
        for (int i = sorted.size() - 1; i >= 0; i--) {
            st.add(sorted.get(i));
            max[sorted.get(i)] = Math.max(max[sorted.get(i)], 1);
            while (!st.empty()) {
                Integer to = st.pop();
                if (ig.containsKey(to)) {
                    for (int j : ig.get(to)) {
                        max[j] = Math.max(max[j], max[to] + 1);
                    }
                }
            }
        }
        int ans = 0;
        for (int j : max) {
            ans = Math.max(j, ans);
        }
        return ans;
    }

    private static void topSort(ArrayList<Integer> sorted) {
        boolean[] visited = new boolean[local];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i, visited, st);
            }
        }
        sorted.addAll(st);
    }

    private static void dfs(int i, boolean[] visited, Stack<Integer> st) {
        visited[i] = true;
        if (ig.containsKey(i)) {
            for (int j : ig.get(i)) {
                if (!visited[j]) {
                    dfs(j, visited, st);
                }
            }
        }
        st.push(i);
    }

    private static void buildGraph(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i + 1 < matrix.length && matrix[i][j] < matrix[i + 1][j]) {
                    addEdge(global, global + matrix[i].length);
                }
                if (i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]) {
                    addEdge(global, global - matrix[i - 1].length);
                }
                if (j + 1 < matrix[i].length && matrix[i][j] < matrix[i][j + 1]) {
                    addEdge(global, global + 1);
                }
                if (j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]) {
                    addEdge(global, global - 1);
                }
                ++global;
            }
        }
    }

    private static void addEdge(int from, int to) {
        if (vMapping.containsKey(from)) {
            from = vMapping.get(from);
        } else {
            vMapping.put(from, local);
            from = local++;
        }
        if (vMapping.containsKey(to)) {
            to = vMapping.get(to);
        } else {
            vMapping.put(to, local);
            to = local++;
        }

        if (g.containsKey(from)) {
            g.get(from).add(to);
        } else {
            LinkedList<Integer> vals = new LinkedList<>();
            vals.add(to);
            g.put(from, vals);
        }

        if (ig.containsKey(to)) {
            ig.get(to).add(from);
        } else {
            LinkedList<Integer> vals = new LinkedList<>();
            vals.add(from);
            ig.put(to, vals);
        }
    }
}