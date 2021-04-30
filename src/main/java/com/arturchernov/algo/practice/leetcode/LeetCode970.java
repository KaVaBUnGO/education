package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 970. Powerful Integers
 * <p>
 * Given three integers x, y, and bound,
 * return a list of all the powerful integers that have a value less than or equal to bound.
 * <p>
 * An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.
 * <p>
 * You may return the answer in any order. In your answer, each value should occur at most once.
 * <p>
 * Example 1:
 * <p>
 * Input: x = 2, y = 3, bound = 10
 * Output: [2,3,4,5,7,9,10]
 * Explanation:
 * 2 = 20 + 30
 * 3 = 21 + 30
 * 4 = 20 + 31
 * 5 = 21 + 31
 * 7 = 22 + 31
 * 9 = 23 + 30
 * 10 = 20 + 32
 * Example 2:
 * <p>
 * Input: x = 3, y = 5, bound = 15
 * Output: [2,4,6,8,10,14]
 * <p>
 * Constraints:
 * <p>
 * 1 <= x, y <= 100
 * 0 <= bound <= 106
 */
public class LeetCode970 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode970()).start();
    }

    @Override
    public void run() {
        System.out.println(powerfulIntegers(2, 3, 10));
        System.out.println(powerfulIntegers(3, 5, 15));
        System.out.println(powerfulIntegers(1, 5, 15));
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        fill(x, first, bound);
        fill(y, second, bound);
        int n = first.size();
        int m = second.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = first.get(i) + second.get(j);
                if (sum > bound) {
                    break;
                }
                ans.add(sum);
            }
        }
        return new ArrayList<>(ans);
    }

    private void fill(int n, List<Integer> a, int max) {
        if (n == 1) {
            a.add(1);
            return;
        }
        int it = 0;
        while (true) {
            int k = (int) Math.pow(n, it++);
            if (k > max) {
                break;
            }
            a.add(k);
        }
    }
}
