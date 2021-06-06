package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1383. Maximum Performance of a Team
 * <p>
 * You are given two integers n and k and two integer arrays speed and efficiency
 * both of length n. There are n engineers numbered from 1 to n. speed[i] and efficiency[i]
 * represent the speed and efficiency of the ith engineer respectively.
 * <p>
 * Choose at most k different engineers out of the n engineers to form a team with the maximum performance.
 * <p>
 * The performance of a team is the sum of their engineers' speeds multiplied by the minimum
 * efficiency among their engineers.
 * <p>
 * Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
 * Output: 60
 * Explanation:
 * We have the maximum performance of the team by selecting engineer 2 (with speed=10 and efficiency=4)
 * and engineer 5 (with speed=5 and efficiency=7). That is, performance = (10 + 5) * min(4, 7) = 60.
 * Example 2:
 * <p>
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
 * Output: 68
 * Explanation:
 * This is the same example as the first but k = 3. We can select engineer 1, engineer 2 and engineer 5
 * to get the maximum performance of the team. That is, performance = (2 + 10 + 5) * min(5, 4, 7) = 68.
 * Example 3:
 * <p>
 * Input: n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
 * Output: 72
 * <p>
 * Constraints:
 * <p>
 * 1 <= <= k <= n <= 105
 * speed.length == n
 * efficiency.length == n
 * 1 <= speed[i] <= 105
 * 1 <= efficiency[i] <= 108
 */
public class LeetCode1383 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode1383()).start();
    }

    @Override
    public void run() {
        System.out.println(maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2));
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Pair arr[] = new Pair[n];
        for (int i = 0; i < n; i++) arr[i] = new Pair(speed[i], efficiency[i]);
        Arrays.sort(arr);
        int m = 1000000007;
        PriorityQueue<Integer> pq = new PriorityQueue();
        long totalSpeed = 0;
        long ans = Long.MIN_VALUE;

        for (Pair pair : arr) {
            if (pq.size() < k) {
                pq.add(pair.speed);
                totalSpeed += pair.speed;
            } else {
                totalSpeed -= pq.remove();
                pq.add(pair.speed);
                totalSpeed += pair.speed;
            }
            ans = Math.max(ans, totalSpeed * pair.efficiency);
        }

        return (int) (ans % m);
    }

    class Pair implements Comparable<Pair> {
        int speed;
        int efficiency;

        public Pair(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }

        public int compareTo(Pair other) {
            if (this.efficiency > other.efficiency) return -1;
            else if (this.efficiency < other.efficiency) return 1;
            return 0;
        }
    }
}
