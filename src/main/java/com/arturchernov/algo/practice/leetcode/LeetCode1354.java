package com.arturchernov.algo.practice.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1354. Construct Target Array With Multiple Sums
 * <p>
 * Given an array of integers target. From a starting array,
 * A consisting of all 1's, you may perform the following procedure :
 * <p>
 * let x be the sum of all elements currently in your array.
 * choose index i, such that 0 <= i < target.size and set the value of A at index i to x.
 * You may repeat this procedure as many times as needed.
 * Return True if it is possible to construct the target array from A otherwise return False.
 * <p>
 * Example 1:
 * <p>
 * Input: target = [9,3,5]
 * Output: true
 * Explanation: Start with [1, 1, 1]
 * [1, 1, 1], sum = 3 choose index 1
 * [1, 3, 1], sum = 5 choose index 2
 * [1, 3, 5], sum = 9 choose index 0
 * [9, 3, 5] Done
 * Example 2:
 * <p>
 * Input: target = [1,1,1,2]
 * Output: false
 * Explanation: Impossible to create target array from [1,1,1,1].
 * Example 3:
 * <p>
 * Input: target = [8,5]
 * Output: true
 * <p>
 * Constraints:
 * <p>
 * N == target.length
 * 1 <= target.length <= 5 * 10^4
 * 1 <= target[i] <= 10^9
 */
public class LeetCode1354 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode1354()).start();
    }

    @Override
    public void run() {
        System.out.println(isPossible(new int[]{9, 3, 5}));
        System.out.println(isPossible(new int[]{1, 1, 1, 2}));
        System.out.println(isPossible(new int[]{8, 5}));
    }

    public boolean isPossible(int[] target) {
        Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        long total = 0;
        for (int i = 0; i < target.length; i++) {
            total += target[i];
            q.add(target[i]);
        }
        while (true) {
            int a = q.poll();
            total -= a;
            if (a == 1 || total == 1) {
                return true;
            }
            if (a < total || total == 0 || a % total == 0) {
                return false;
            }
            a %= total;
            total += a;
            q.add(a);
        }
    }
}
