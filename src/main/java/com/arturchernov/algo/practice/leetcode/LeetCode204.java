package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 204. Count Primes
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * Example 2:
 * <p>
 * Input: n = 0
 * Output: 0
 * Example 3:
 * <p>
 * Input: n = 1
 * Output: 0
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 5 * 10^6
 */
public class LeetCode204 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode204()).start();
    }

    @Override
    public void run() {
        System.out.println(countPrimes(100));
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(0));
        System.out.println(countPrimes(1));
    }

    public int countPrimes(int n) {
        boolean[] dp = new boolean[n];
        int ans = 0;
        double sqrt = Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            fill(i, dp, n);
        }
        for (int i = 2; i < n; i++) {
            if (!dp[i]) {
                ans++;
            }
        }
        return ans;
    }

    private void fill(int a, boolean[] dp, int max) {
        if (dp[a]) return;
        int it = 2;
        int k = it * a;
        while (k < max) {
            dp[k] = true;
            ++it;
            k = it * a;
        }
    }
}
