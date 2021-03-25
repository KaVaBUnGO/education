package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 870. Advantage Shuffle
 * <p>
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 * <p>
 * Return any permutation of A that maximizes its advantage with respect to B.
 * Example 1:
 * <p>
 * Input: A = [2,7,11,15], B = [1,10,4,11]
 * Output: [2,11,7,15]
 * Example 2:
 * <p>
 * Input: A = [12,24,8,32], B = [13,25,32,11]
 * Output: [24,32,8,12]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 * Accepted
 */
public class LeetCode870 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2})));
        System.out.println(Arrays.toString(advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
        System.out.println(Arrays.toString(advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
    }

    public static int[] advantageCount(int[] A, int[] B) {
        Pair[] b = new Pair[B.length];
        for (int i = 0; i < B.length; i++) {
            b[i] = new Pair(B[i], i);
        }
        Arrays.sort(A);
        Arrays.sort(b, Comparator.comparing(o -> o.val));

        int aIndex = 0, bIndex = 0;
        int last = b.length - 1;
        while (true) {
            if (aIndex >= A.length) {
                break;
            }
            if (A[aIndex] > b[bIndex].val) {
                B[b[bIndex++].pos] = A[aIndex++];
            } else {
                B[b[last--].pos] = A[aIndex++];
            }
        }
        return B;
    }

    static class Pair {
        int val;
        int pos;

        public Pair(int val, int pos) {
            this.val = val;
            this.pos = pos;
        }
    }
}