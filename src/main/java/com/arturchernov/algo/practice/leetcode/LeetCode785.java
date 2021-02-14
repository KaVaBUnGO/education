package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 785. Is Graph Bipartite?
 * <p>
 * Given an undirected graph, return true if and only if it is bipartite.
 * <p>
 * Recall that a graph is bipartite if we can split its set of nodes into two independent subsets A and B,
 * such that every edge in the graph has one node in A and another node in B.
 * <p>
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.
 * Each node is an integer between 0 and graph.length - 1. There are no self edges or parallel edges:
 * graph[i] does not contain i, and it doesn't contain any element twice.
 */
public class LeetCode785 {

    public static void main(String[] args) {
        System.out.println(isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}}));
        System.out.println(isBipartite(new int[][]{{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}}));
        System.out.println(isBipartite(new int[][]{{1}, {0}, {}, {}}));
        System.out.println(isBipartite(new int[][]{{}, {}, {}, {}}));
        System.out.println(isBipartite(new int[][]{{}, {}, {}, {}}));
    }

    public static boolean isBipartite(int[][] graph) {
        Stack<Byte> st = new Stack<>();
        boolean[] used = new boolean[graph.length];
        byte[] color = new byte[graph.length];
        Arrays.fill(color, (byte) 2);

        for (byte k = 0; k < graph.length; k++) {
            if (graph[k].length > 0 && !used[k]) {
                st.add(k);
                used[k] = true;
                color[k] = 1;

                while (!st.isEmpty()) {
                    Byte cur = st.pop();
                    for (byte i = 0; i < graph[cur].length; i++) {
                        byte v = (byte) graph[cur][i];
                        if (color[v] == 2) {
                            color[v] = (byte) ((color[cur] + 1) % 2);
                        } else {
                            if (color[v] != (byte) ((color[cur] + 1) % 2)) {
                                return false;
                            }
                        }

                        if (!used[v]) {
                            st.push(v);
                            used[v] = true;
                        }
                    }
                }
            }
        }

        return true;
    }
}