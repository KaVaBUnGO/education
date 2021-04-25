package com.arturchernov.algo.practice.leetcode;

import java.util.*;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1192. Critical Connections in a Network
 * <p>
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a
 * network where connections[i] = [a, b] represents a connection between servers a and b.
 * Any server can reach any other server directly or indirectly through the network.
 * <p>
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 * <p>
 * Return all critical connections in the network in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5
 * n-1 <= connections.length <= 10^5
 * connections[i][0] != connections[i][1]
 * There are no repeated connections.
 */
public class LeetCode1192 {
    static boolean[] used;
    static int timer = 0;
    static int[] tin;
    static int[] fup;
    static Map<Integer, List<Integer>> g;
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        int[][] ints = {{0, 1}, {1, 2}, {2, 0}, {1, 3}};

        List<List<Integer>> connections = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            connections.add(new ArrayList<>());
            for (int j = 0; j < ints[i].length; j++) {
                connections.get(i).add(ints[i][j]);
            }
        }
        System.out.println(criticalConnections(4, connections));
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> c) {
        g = buildGraph(c);
        used = new boolean[n];
        tin = new int[n];
        fup = new int[n];
        dfs(0, -1);
        return ans;
    }

    private static void dfs(int v, int p) {
        used[v] = true;
        tin[v] = timer++;
        fup[v] = tin[v];
        for (Integer to : g.get(v)) {
            if (to == p) {
                continue;
            }
            if (used[to]) {
                fup[v] = Math.min(fup[v], tin[to]);
            } else {
                dfs(to, v);
                fup[v] = Math.min(fup[v], fup[to]);
                if (fup[to] > tin[v]) {
                    ans.add(Arrays.asList(v, to));
                }
            }
        }
    }

    private static Map<Integer, List<Integer>> buildGraph(List<List<Integer>> g) {
        Map<Integer, List<Integer>> res = new HashMap<>();
        for (int i = 0; i < g.size(); i++) {
            Integer from = g.get(i).get(0);
            Integer to = g.get(i).get(1);
            if (!res.containsKey(from)) {
                res.put(from, new ArrayList<>());
            }
            res.get(from).add(to);
            if (!res.containsKey(to)) {
                res.put(to, new ArrayList<>());
            }
            res.get(to).add(from);
        }
        return res;
    }

}