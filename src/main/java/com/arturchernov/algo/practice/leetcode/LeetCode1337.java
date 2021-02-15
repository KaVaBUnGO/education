package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1337. The K Weakest Rows in a Matrix
 * <p>
 * Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of
 * the k weakest rows in the matrix ordered from the weakest to the strongest.
 * <p>
 * A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j,
 * or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row,
 * that is, always ones may appear first and then zeros.
 */
public class LeetCode1337 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(kWeakestRows(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}}, 3)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        Pair[] power = new Pair[mat.length];
        for (int i = 0; i < mat.length; i++) {
            Pair pair = new Pair(i);
            for (int j : mat[i]) {
                pair.power += j;
            }
            power[i] = pair;
        }
        return Arrays.stream(power)
                .sorted(Comparator.comparingInt(o -> o.power))
                .mapToInt(pair -> pair.idx)
                .limit(k)
                .toArray();
    }

    private static class Pair {
        int idx;
        int power = 0;

        public Pair(int idx) {
            this.idx = idx;
        }
    }
}